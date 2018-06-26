package gov.psm.secondary.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("gov.psm.secondary.service.controller"))              
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo())
          .useDefaultResponseMessages(false);
    }
    
    
    private static ApiInfo apiInfo() {
        return new ApiInfo(
          "Secondary Service API",
          "Documentation describing RESTful endpoints hosted by the Secondary Service",
          "v 0.0.1-SNAPSHOT",
          null,
          new Contact("Yogesh Bansal", null, "ybansal369@gmail.com"),
          null,
          null);
    }
}
