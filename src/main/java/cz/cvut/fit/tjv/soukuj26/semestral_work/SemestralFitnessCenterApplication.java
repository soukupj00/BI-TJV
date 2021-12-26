package cz.cvut.fit.tjv.soukuj26.semestral_work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class SemestralFitnessCenterApplication {

	public static void main(String... args) {
		SpringApplication.run(SemestralFitnessCenterApplication.class, args);
	}

	/**
	 * Allows all api requests to go through, when something fails, throws exception that can be read by human
	 * Probably filters which apis get access to server?
	 * <a href = "https://stackoverflow.com/questions/53978113/spring-boot-with-angular-access-to-xmlhttprequest-at-http-localhost8080-f">StackOverflow</a>
	 * @return Cors
	 */
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		//This throws errors for "*" while we allowCredentials
		//config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}