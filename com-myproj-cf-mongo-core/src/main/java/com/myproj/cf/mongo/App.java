package com.myproj.cf.mongo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.sap.orca.starter.core.config.ApplicationConfig;
import com.sap.orca.starter.core.security.AuthenticationType;
import com.sap.orca.starter.core.security.SecurityConfig;
import com.sap.orca.starter.core.security.SecurityConfigBuilder;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication(scanBasePackages = { "com.myproj.cf.mongo"},
        exclude = { DataSourceAutoConfiguration.class })
@OpenAPIDefinition(
        info = @Info(
                description = "my test project",
                version = "1.0",
                title = "Test Project"
        ),
        externalDocs = @ExternalDocumentation(               
                description = "https://. . ."
        )
)

@Configuration
@EnableWebSecurity
public class App extends SpringBootServletInitializer {
    @Bean(name = "AppConfig")
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ApplicationConfig appConfig() {
        return new ApplicationConfig() {
            @Override
            public String getApplicationName() {
                return "com-myproj-cf-mongo";
            }
        };
    }


    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class).run(args);
    }
}
