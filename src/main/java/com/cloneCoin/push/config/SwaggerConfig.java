package com.cloneCoin.push.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi pushGroupApi() {
        return GroupedOpenApi.builder()
                .group("push")
                .pathsToMatch("/push/**")
                .build();
    }

}
