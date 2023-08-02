package com.diana.insurance.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenApi() {
        Info info = new Info()
                .title("Insurance API")
                .version("1.0")
                .description("This API exposes endpoints to manage insurance application.");
        return new OpenAPI().info(info);
    }
}

//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public OpenAPI myOpenAPI() {
//        Info info = new Info()
//                .title("Insurance API")
//                .version("1.0")
//                .description("This API exposes endpoints to manage insurance application.");
//        return new OpenAPI().info(info);
//    }
//}
