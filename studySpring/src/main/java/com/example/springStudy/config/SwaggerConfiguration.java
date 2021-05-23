package com.example.springStudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
 
 
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                 /*Controller层的包地址*/
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.Controller"))
                /*接口请求地址前缀rest
                 *  比如 @RequestMapping(value = "/rest/article/{id}")     
                    可以写 /.* 但是要写明 接口发送post或get 或等等     
                 *
                 */ 
                 .paths(PathSelectors.regex("/rest/.*"))
                .build();
    }
 
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui RESTful APIs")
                .description("swagger-bootstrap-ui")
                .termsOfServiceUrl("http://localhost:8080/")
                .contact("TongLing")
                .version("1.0")
                .build();
    }
 
}

