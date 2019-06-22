/**
 * 
 */
package br.com.cams7.app.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ceanm
 *
 */
@Configuration
//FIXME Quando é usada a anotação @EnableWebMvc ocorre um erro na exibição do JSON
//@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		 registry.addMapping("/**")
         //.allowedOrigins("http://localhost:4200")
         .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
         .allowCredentials(true);
	}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver phmar = new PageableHandlerMethodArgumentResolver();
		phmar.setFallbackPageable(PageRequest.of(0, 5));
		argumentResolvers.add(phmar);
	}
}
