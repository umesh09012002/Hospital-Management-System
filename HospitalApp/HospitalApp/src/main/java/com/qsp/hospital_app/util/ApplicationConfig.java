package com.qsp.hospital_app.util;

import java.util.ArrayList;
import java.util.List;

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
public class ApplicationConfig {

	public Docket getDocket() {
		Contact contact = new Contact("QSP", "www.qsp.com", "qspsupport@mail.com");

		List<VendorExtension> extensions = new ArrayList();

		ApiInfo apiInfo = new ApiInfo("Hospital App", "Hospital app v1.0", "version 1.0", "www.qspservice.com", contact,
				"asdfg123qwert", "www.qsplicense.com", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.qsp.hospital_app")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}

}
