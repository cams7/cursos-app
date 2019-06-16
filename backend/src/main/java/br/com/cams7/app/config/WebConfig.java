/**
 * 
 */
package br.com.cams7.app.config;

import org.springframework.context.annotation.Configuration;
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
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		 registry.addMapping("/**")
         .allowedOrigins("http://localhost:4200")
         .allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD")
         .allowCredentials(true);
	}
}
