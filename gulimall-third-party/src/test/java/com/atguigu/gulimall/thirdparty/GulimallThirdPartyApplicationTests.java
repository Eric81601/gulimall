package com.atguigu.gulimall.thirdparty;

import com.aliyun.oss.OSS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallThirdPartyApplicationTests {

    @Autowired
    OSS ossClient;

    @Test
    public void testUpload() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("D:\\1f15cdbcf9e1273c.jpg");
        ossClient.putObject("gulimall-ericliu", "test222.jpg", inputStream);
        ossClient.shutdown();
        System.out.println("上传成功!");
    }

    @Test
    public void contextLoads() {
    }

}
