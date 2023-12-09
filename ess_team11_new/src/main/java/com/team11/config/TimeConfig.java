package com.team11.config;

import com.team11.util.StringToDateConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TimeConfig implements WebMvcConfigurer {
    //实现WebMvcConfigurer接口中的addInterceptors方法
    public void addFormatters(FormatterRegistry registry) {
        //注册引用时间类型转换类
        registry.addConverter(new StringToDateConverter());
    }
}
