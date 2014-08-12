package configuration;

import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.annotation.WebFilter;

/**
 * User: 67726e
 */
@WebFilter(filterName = "encoding-filter", urlPatterns = "/*")
public class EncodingFilter extends CharacterEncodingFilter {
	public EncodingFilter() {
		setEncoding("UTF-8");
		setForceEncoding(true);
	}
}
