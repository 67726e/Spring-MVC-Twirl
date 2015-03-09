package controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import us.hexcoder.twirl.view.TwirlView
import us.hexcoder.twirl.{Redirect, TwirlView}

/**
 * User: 67726e
 */
@Controller
@RequestMapping(value = Array("/"))
class IndexController {
//	@RequestMapping(value = Array("/"), method = Array(RequestMethod.GET))
//	def index():TwirlView = {
//		new TwirlView()
//	}

	@RequestMapping(value = Array("/test.html"), method = Array(RequestMethod.GET))
	def getHtml():TwirlView = {
        TwirlView.ok(html.index())
    }

	@RequestMapping(value = Array("/test.xml"), method = Array(RequestMethod.GET))
	def getXml():TwirlView = {
		TwirlView.ok(xml.test())
	}

	@RequestMapping(value = Array("/test.txt"), method = Array(RequestMethod.GET))
	def getTxt():TwirlView = {
        TwirlView.ok(txt.test())
	}

	@RequestMapping(value = Array("/test.js"), method = Array(RequestMethod.GET))
	def getJs():TwirlView = {
        TwirlView.ok(js.application())
	}

	@RequestMapping(value = Array("/redirect"), method = Array(RequestMethod.GET))
	def redirect():TwirlView = {
        TwirlView.redirect("/test.html")
	}
}
