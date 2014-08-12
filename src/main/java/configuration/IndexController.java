package configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import twirl.Redirect;
import twirl.TwirlView;

/**
 * User: 67726e
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getIndex() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/test.html", method = RequestMethod.GET)
	public TwirlView getHtml() {
		return new TwirlView(html.index.apply());
	}

	@RequestMapping(value = "/test.js", method = RequestMethod.GET)
	public TwirlView getJs() {
		return new TwirlView(js.application.apply());
	}

	@RequestMapping(value = "/test.xml", method = RequestMethod.GET)
	public TwirlView getXml() {
		return new TwirlView(xml.test.apply());
	}

	@RequestMapping(value = "/test.txt", method = RequestMethod.GET)
	public TwirlView getText() {
		return new TwirlView(txt.test.apply());
	}

	@RequestMapping(value = "/redirect", method = RequestMethod.GET)
	public TwirlView getRedirect() {
		return new TwirlView(new Redirect("/test.html"));
	}
}
