package com.CidenetShop.CidenetShopBackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_12)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.CidenetShop.CidenetShopBackend"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo (){
        return new ApiInfo(
                "Cidenet Shop",
                "Una compañía emergente llamada Cidenet Shop situada en Colombia y dedicada a la venta de productos a través de internet.",
                "2.0",
                "Programa Digital School y Cidenet",
                new Contact("Yorman Agudelo","https://github.com/Cuburi","yormanalexis2001@gmail.com"),
                "",
                "",
                Collections.emptyList()
        );
    }
}
