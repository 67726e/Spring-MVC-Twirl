package controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import us.hexcoder.twirl.{Redirect, TwirlView}

/**
 * User: 67726e
 */
@Controller
@RequestMapping(value = Array("/"))
class IndexController {
	@RequestMapping(value = Array("/"), method = Array(RequestMethod.GET))
	def index():TwirlView = {
		new TwirlView()
	}

	@RequestMapping(value = Array("/test.html"), method = Array(RequestMethod.GET))
	def getHtml():TwirlView = {
		new TwirlView(html.index())
	}

	@RequestMapping(value = Array("/test.xml"), method = Array(RequestMethod.GET))
	def getXml():TwirlView = {
		new TwirlView(xml.test())
	}

	@RequestMapping(value = Array("/test.txt"), method = Array(RequestMethod.GET))
	def getTxt():TwirlView = {
		new TwirlView(txt.test())
	}

	@RequestMapping(value = Array("/test.js"), method = Array(RequestMethod.GET))
	def getJs():TwirlView = {
		new TwirlView(js.application())
	}

	@RequestMapping(value = Array("/redirect"), method = Array(RequestMethod.GET))
	def redirect():TwirlView = {
		new TwirlView(new Redirect("/test.html"))
	}
}
