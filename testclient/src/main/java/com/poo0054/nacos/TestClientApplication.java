package com.poo0054.nacos;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

/**
 * @author poo00
 */
@SpringBootApplication
public class TestClientApplication {
    public static void main(String[] args) throws NacosException {
        SpringApplication.run(TestClientApplication.class, args);

        String serverAddr = "{serverAddr}";
        String dataId = "{dataId}";
        String group = "{group}";
        Properties properties = new Properties();
        properties.put("serverAddr", serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);
    }
}