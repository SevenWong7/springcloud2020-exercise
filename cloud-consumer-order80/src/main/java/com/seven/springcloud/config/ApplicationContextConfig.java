package com.seven.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author SevenWong
 * @date 2021-01-07 17:48:03
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * http rest请求工具
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
