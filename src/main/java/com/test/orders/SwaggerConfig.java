package com.test.orders;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket deliunquencyApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.test.orders.controller")).paths(regex("/.*")).build()
				.apiInfo(metaData());
	}

	/**
	 * @return
	 */
	private ApiInfo metaData() {
		@SuppressWarnings("rawtypes")
		ApiInfo apiInfo = new ApiInfo("Omnicuris", "Orders Management System", "1.0", "Terms of service",
				new Contact("Omnicuris", "www.omnicuris.com", "test@gmail.com"), "Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
		return apiInfo;
	}
}
