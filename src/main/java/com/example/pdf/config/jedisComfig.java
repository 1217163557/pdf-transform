package com.example.pdf.config;


import com.example.pdf.utils.JedisUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class jedisComfig {


    @Bean
    public JedisUtil createJedis(){
        return  new JedisUtil("39.96.56.216",6379);
    }
}
