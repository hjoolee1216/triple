package com.example.demo.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.any;


@Configuration
@EnableSwagger2
@Slf4j
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    @Bean
    public Docket api() {
        // log.info(">> call Swagger Configuration");
        //@formatter:off
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(any())
                .build()
                .apiInfo(this.metaData())
                .useDefaultResponseMessages(false)
                .globalResponseMessage(
                        RequestMethod.GET,
                        newArrayList(
                                new ResponseMessageBuilder()
                                        .code(500)
                                        .message("500 Message")
                                        .responseModel(new ModelRef("Error"))
                                        .build(),
                                new ResponseMessageBuilder()
                                        .code(403)
                                        .message("Forbidden!!")
                                        .build()
                        )
                );
        //@formatter:on
    }


    private ApiInfo metaData() {
        return new ApiInfo("taxi call API", "taxi call API", "1.0", "Terms of Service",
                new Contact("Dev. Team/Sever Part", "", "hjoolee1216.lee@gmail.com"),
                "Apache License Version 2.0", "http://www.apache.org/license/LICENSE-2.0", Collections.emptyList());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
