package com.team11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @SpringBootApplication 声明入口类 且声明是springboot项目的
 */
@SpringBootApplication
public class EssApplication {

    public static void main(String[] args) {
        //使用springApplication类的静态方法 启动springboot程序
        //方法参数 - 程序的入口类,main函数的参数
        SpringApplication.run(EssApplication.class,args);
    }

}