package com.coredge.killbill.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "com.coredge";
	private static final String PATH_NAME_V1 = "/**";
	private static final String PARAMETER_TYPE_HEADER = "header";
	private static final String MODEL_REF_STRING = "string";

	@Bean
	public Docket swaggerNdhmApi10() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.ant(PATH_NAME_V1)).build().globalOperationParameters(parameters());
	}

	private List<Parameter> parameters() {
		Parameter username = parameter("Username", PARAMETER_TYPE_HEADER, MODEL_REF_STRING, "admin", true, null);
		Parameter password = parameter("password", PARAMETER_TYPE_HEADER, MODEL_REF_STRING, "password", true, null);
		Parameter apiKey = parameter("Api-key", PARAMETER_TYPE_HEADER, MODEL_REF_STRING, "bob", true, null);
		Parameter apiSecret = parameter("Api-Secret", PARAMETER_TYPE_HEADER, MODEL_REF_STRING, "lazar", true, null);

		return Arrays.asList(username, password, apiKey, apiSecret);
	}

	private Parameter parameter(String name, String type, String modelRef, String defaultValue, boolean required,
			String description) {
		ParameterBuilder parameters = new ParameterBuilder();
		parameters.name(name) // name of header
				.modelRef(new ModelRef(modelRef)).parameterType(type) // type - header
				.defaultValue(defaultValue).required(required) // for compulsory
				.description(description).build();
		return parameters.build();
	}

}
