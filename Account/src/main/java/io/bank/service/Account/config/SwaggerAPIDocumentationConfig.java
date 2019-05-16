package io.bank.service.Account.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.*;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@EnableSwagger2
@Configuration
public class SwaggerAPIDocumentationConfig {
    @Autowired
    private BuildProperties props;

    ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(props.getName() + " REST operations ")
                                   .description("Micro service using, REST API using Spring Boot eureka build at : " + props.getTime())
                                   .termsOfServiceUrl(props.getArtifact())
                                   .version(props.getVersion())
                                   .build();
    }

    @Bean
    public Docket configureControllerPackageAndConvertors() {
        return new Docket(SWAGGER_2).select()
                                    .apis(basePackage(props.getGroup()))
                                    .build()
                                    .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
                                    .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
                                    .apiInfo(apiInfo());
    }
}
