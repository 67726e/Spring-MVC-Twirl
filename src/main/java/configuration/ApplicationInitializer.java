package configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * User: 67726e
 */
public class ApplicationInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Setup the servlet container to use our specified (UTF-8) encoding
		servletContext.addFilter("encoding-filter", EncodingFilter.class);

		// Initialize the Spring context within which we will dispatch incoming requests
		AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
		springContext.register(ApplicationConfiguration.class);
		springContext.setServletContext(servletContext);

		// Setup Spring MVC dispatcher servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("spring-dispatcher", new DispatcherServlet(springContext));
		dispatcher.setLoadOnStartup(0);
		dispatcher.addMapping("/");
	}

}
