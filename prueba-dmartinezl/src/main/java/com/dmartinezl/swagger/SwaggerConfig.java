package com.dmartinezl.swagger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@Profile({"!prod && development"})
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer{


	@Bean
	public Docket api() {
		
		Contact contact = new Contact(
	               "Douglas Martinez L",
	               "https://www.linkedin.com/in/douglas-alexander-mart%C3%ADnez-loor-02756515a/", 
	               "dougman960@gmail.com"
	       );
	       
	       @SuppressWarnings("rawtypes")
		List<VendorExtension> vendorExtensions = new ArrayList<>();
	       
	       ApiInfo apiInfo = new ApiInfo(
	      "RESTful Prueba", 
	      "Page Restfull Prueba ", "1.0",
	      "", contact, 
	      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",vendorExtensions);
		
		return new Docket(DocumentationType.SWAGGER_2)
				 .apiInfo(apiInfo)
				 .securityContexts(Arrays.asList(securityContext()))
				 .securitySchemes(Arrays.asList(apiKey()))
				 .select()
			     .apis(RequestHandlerSelectors.basePackage("com.dmartinezl.controller"))
			     .paths(PathSelectors.any())
			     .build();
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");

	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();

	}

	private List<SecurityReference> defaultAuth(){
		 AuthorizationScope authorizationScope =  new AuthorizationScope("global","accesEverything");
		 AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		 authorizationScopes[0] = authorizationScope;
		 return Arrays.asList(new SecurityReference("JWT",authorizationScopes));
	}

	
}
