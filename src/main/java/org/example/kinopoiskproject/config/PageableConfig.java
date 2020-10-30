package org.example.kinopoiskproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;

@Configuration
public class PageableConfig {

//    Настраиваем пагинацию с 1 страницы а не с 0
    @Bean
    PageableHandlerMethodArgumentResolverCustomizer pageableHandlerMethodArgumentResolverCustomizer(){
        return pageableResolver -> pageableResolver.setOneIndexedParameters(true);
    }
}
