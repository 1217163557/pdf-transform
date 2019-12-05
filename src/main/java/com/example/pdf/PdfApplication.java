package com.example.pdf;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.example.pdf.mapper")
public class PdfApplication {
    private final static Logger logger= LoggerFactory.getLogger(PdfApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(PdfApplication.class, args);
        logger.info("PdfApplication started");
    }

}
