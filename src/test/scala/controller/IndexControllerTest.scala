package controller

import _root_.configuration.ApplicationConfiguration
import com.google.common.net.MediaType
import org.junit.runner.RunWith
import org.junit.{Before, Test}
import org.scalatest.junit.JUnitSuite
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.{content, redirectedUrl, status}
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

/**
 * User: 67726e
 */
@RunWith(classOf[SpringJUnit4ClassRunner])
@WebAppConfiguration
@ContextConfiguration(classes = Array(classOf[ApplicationConfiguration]))
class IndexControllerTest extends JUnitSuite {
	@Autowired
	val webApplicationContext: WebApplicationContext = null
	var mockMvc: MockMvc = _

	@Before
	def setup():Unit = {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
	}

	@Test
	@throws[Exception]
	def testHtml():Unit = {
		mockMvc.perform(get("/test.html"))
			.andExpect(status().isOk)
			.andExpect(content().contentType(MediaType.HTML_UTF_8.toString))
	}

	@Test
	@throws[Exception]
	def testXml():Unit = {
		mockMvc.perform(get("/test.xml"))
			.andExpect(status.isOk)
			.andExpect(content().contentType(MediaType.XML_UTF_8.toString))
	}

	@Test
	@throws[Exception]
	def testTxt():Unit = {
		mockMvc.perform(get("/test.txt"))
			.andExpect(status.isOk)
			.andExpect(content().contentType(MediaType.PLAIN_TEXT_UTF_8.toString))
	}

	@Test
	@throws[Exception]
	def testJs():Unit = {
		mockMvc.perform(get("/test.js"))
			.andExpect(status().isOk)
			.andExpect(content().contentType(MediaType.JAVASCRIPT_UTF_8.toString))
	}

	@Test
	@throws[Exception]
	def testRedirect():Unit = {
		mockMvc.perform(get("/redirect"))
			.andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/test.html"))
	}

	@Test
	@throws[Exception]
	def testDefault():Unit = {
		mockMvc.perform(get("/"))
			.andExpect(status().isNoContent)
	}
}
