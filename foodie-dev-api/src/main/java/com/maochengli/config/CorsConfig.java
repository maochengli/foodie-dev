package com.maochengli.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *  跨域访问配置类
 */
@Configuration
public class CorsConfig {

    public CorsConfig() {
    }


    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration configuration = new CorsConfiguration();
        //设置允许访问的路径
        configuration.addAllowedOrigin("*");
        //设置允许cookie
        configuration.setAllowCredentials(true);
        //设置允许访问的httpMethod
        configuration.addAllowedMethod("*");
        //设置允许携带所有header
        configuration.addAllowedHeader("*");
        //添加url映射路径
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);

        return  new CorsFilter(source);

    }
}
