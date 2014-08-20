package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import us.hexcoder.twirl.TwirlView;

/**
 * User: 67726e
 */
@Configuration
@EnableWebMvc
@ComponentScan({"controller", "controller.configuration"})
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver setupViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();

		viewResolver.setOrder(0);
		viewResolver.setViewClass(TwirlView.class);

		return viewResolver;
	}
}
