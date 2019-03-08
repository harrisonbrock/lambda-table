package com.lambdaschool.lambdatable.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// http://localhost:8080/swagger-ui.html

@Configuration
@EnableSwagger2
public class Swagger2Config
{
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.lambdaschool.lambda-table"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo()
    {
        return new ApiInfoBuilder().title("Cloud Chart")
                .description("Cloud Chart is our version of Airtable which is a spreadsheet-database hybrid, with the features of a database but applied to a spreadsheet.")
                .contact(new Contact("Cruise Brantley", "http://www.lambdaschool.com", "cruise@lambdaschool.com"))
                .contact(new Contact("Harrison Brock", "http://www.lambdaschool.com", "harrison@lambdaschool.com"))
                .contact(new Contact("Kaitlyn Flynn", "http://www.lambdaschool.com", "kaitlyn@lambdaschool.com"))
                .license("MIT")
                .licenseUrl("https://github.com/LambdaSchool/java-crudysnacks/blob/master/LICENSE")
                .version("1.0.0")
                .build();
    }
}