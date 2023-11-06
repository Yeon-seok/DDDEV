package com.d103.dddev.config;

import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.userdetails.UserDetails;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {

		List<RequestParameter> globalParameters = new ArrayList<>();

		RequestParameter authTokenHeader = new RequestParameterBuilder()
				.name("Authorization")
				.description("Access Token")
				.in(ParameterIn.HEADER.toString())
				.required(false)
				.query(q -> q.model(m -> m.scalarModel(ScalarType.STRING))
						.defaultValue("Bearer "))
				.build();

		globalParameters.add(authTokenHeader);


		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.d103.dddev.api"))
				.build()
				.apiInfo(apiInfo())
				.globalRequestParameters(globalParameters)
				.ignoredParameterTypes(UserDetails.class)
				.useDefaultResponseMessages(true);

//		return new Docket(DocumentationType.SWAGGER_2)
//			.select()
//			.apis(RequestHandlerSelectors.basePackage("com.d103.dddev.api"))
//			.paths(PathSelectors.any())
//			.build()
//			.apiInfo(apiInfo())
//			.enable(true);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("dddev API")
			.description("dddev 어플리케이션에 사용되는 REST API 페이지입니댜")
			.version("1.0")
			.build();
	}
}
