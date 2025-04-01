package com.atguigu.gulimall.search;

import com.alibaba.fastjson.JSON;
import com.atguigu.gulimall.search.config.GulimallElasticSearchConfig;
import lombok.Data;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallSearchApplicationTests {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void searchData() throws IOException {
        //1.创建检索请求
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("bank"); //指定索引
        //指定DSL，检索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //构造检索条件
        searchSourceBuilder.query(QueryBuilders.matchQuery("address", "mill"));

        //按照年龄的分布进行聚合
        TermsAggregationBuilder ageAgg = AggregationBuilders.terms("ageAgg").field("age").size(10);
        searchSourceBuilder.aggregation(ageAgg);

        //计算平均薪资
        SearchSourceBuilder balanceAvg = searchSourceBuilder.aggregation(AggregationBuilders.avg("balanceAvg").field("balance"));
        searchRequest.source(balanceAvg);

        System.out.println("检索条件" + searchSourceBuilder.toString());
        searchRequest.source(searchSourceBuilder);

        //2.执行检索
        SearchResponse search = restHighLevelClient.search(searchRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);

        //3.分析结果
        System.out.println(search.toString());

        //获取检索到的结果
        SearchHits hits = search.getHits();
        SearchHit[] searchHits = hits.getHits();
        for (SearchHit hit : searchHits) {
            String sourceAsString = hit.getSourceAsString();
            System.out.println(sourceAsString);
        }

        //获取检索的分析信息(聚合数据等)
        Aggregations aggregations = search.getAggregations();
        Terms ageAgg1 = aggregations.get("ageAgg");
        for (Terms.Bucket bucket : ageAgg1.getBuckets()) {
            String keyAsString = bucket.getKeyAsString();
            System.out.println("年龄：" + keyAsString + " 岁的有 " + bucket.getDocCount() + " 人");
        }

        Avg balanceAvg1 = aggregations.get("balanceAvg");
        System.out.println("平均薪资: " + balanceAvg1.getValue());
    }

    /**
     * 测试存储数据到ES
     */
    @Test
    public void indexData() throws IOException {
        IndexRequest indexRequest = new IndexRequest("users");
        indexRequest.id("1"); //数据的id
        User user = new User();
        user.setUsername("zhangsan");
        user.setAge(18);
        user.setGender("男");
        String jSONString = JSON.toJSONString(user);
        indexRequest.source(jSONString, XContentType.JSON); //数据存储的数据

        //执行操作
        IndexResponse index = restHighLevelClient.index(indexRequest, GulimallElasticSearchConfig.COMMON_OPTIONS);

        System.out.println(index); //打印出ES的响应数据
    }

    @Data
    static class User {
        private String username;
        private Integer age;
        private String gender;
    }

    @Test
    public void contextLoads() {
        System.out.println(restHighLevelClient);
    }

}
