package com.springland365.bookstore.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
// The EnableWebMvc disables WebMvcAutoConfiguration then causes troulbe on static content
//@EnableWebMvc
@ComponentScan(basePackages = "com.springland365.bookstore.web")
public class WebConfig implements WebMvcConfigurer {


    @Bean
    public ViewResolver  internalResourceViewResolver()
    {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view/");
        bean.setSuffix(".jsp");
        return bean;
    }




}
