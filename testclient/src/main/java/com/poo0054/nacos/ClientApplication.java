package com.poo0054.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.nacos.api.exception.NacosException;

/**
 * @author poo00
 */
@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) throws NacosException {
        SpringApplication.run(ClientApplication.class, args);
    }
}