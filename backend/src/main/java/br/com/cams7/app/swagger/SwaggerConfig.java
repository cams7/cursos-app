/**
 * 
 */
package br.com.cams7.app.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ceanm
 *
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	@Bean
	public Docket greetingApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.cams7.app.controller")).paths(PathSelectors.any())
				.build().apiInfo(metaData());

	}

	private static ApiInfo metaData() {
		return new ApiInfoBuilder().title("Cursos App")
				.description(
						"Uma aplicação desenvolvida para melhor compreensão das tecnologias Angular 8 e String boot 2")
				.version("0.0.1-SNAPSHOT")
				.contact(new Contact("César A. Magalhães", "https://www.linkedin.com/in/cams7", "ceanma@gmail.com"))
				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.build();
	}
}
