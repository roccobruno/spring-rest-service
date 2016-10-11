package com.bruno.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("api-docs-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

//    private ApiInfo apiInfo() {
//        ApiInfo apiInfo = new ApiInfo(
//                "MOP REST API",
//                "Descrizione ......",
//                "1.0",
//                "Terms of service",
//                "SOGEI 2016",
//                "",
//                "");
//        return apiInfo;
//    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("MOP REST APIs").description("Descrizione ...... SEZIONE SICUREZZA - SEZIONE PAGINAZIONE")
                .termsOfServiceUrl("").license("")
                .licenseUrl("").version("1.0").build();
    }
}