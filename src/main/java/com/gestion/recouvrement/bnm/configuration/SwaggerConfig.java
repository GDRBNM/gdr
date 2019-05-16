package com.gestion.recouvrement.bnm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.*;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Banque National de Mauritanie", "http://www.bnm.mr", "bnm@gmail.com");
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Api Gestion de Recouvrement", "Documentation détaillé des apis utiliseés pour l'application de gestion de recovrement",
            "1.0", "urn:tos",
            DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
            Collections.emptyList());
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<String>(Arrays.asList("application/json","application/xml"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)

                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .select()
             //   .apis(RequestHandlerSelectors.basePackage("com.gestion.recouvrement.bnm"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(DEFAULT_API_INFO)
                ;
    }
/*
    @Bean
    ApiInfo apiInfo(){
        final ApiInfoBuilder builder=new ApiInfoBuilder();
        builder.title("Api Gestion de Recouvrement");
        return builder.build();
    }
*/
}