package com.dan.crud.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {
    
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.dan"))
          .paths(PathSelectors.any())
          .build();
    }
	
	 protected void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("swagger-ui.html")
           .addResourceLocations("classpath:/META-INF/resources/");

       registry.addResourceHandler("/webjars/**")
           .addResourceLocations("classpath:/META-INF/resources/webjars/");
     }
	 
	 private static final String[] AUTH_WHITELIST = {
		        "/swagger-resources/**",
		        "/swagger-ui.html",
		        "/v2/api-docs",
		        "/webjars/**"
		};

		public void configure(WebSecurity web)throws Exception {
		    web.ignoring().requestMatchers("/swagger-resources/**");
		}
		
}