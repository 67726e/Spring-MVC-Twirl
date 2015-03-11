package us.hexcoder.twirl.render

import org.junit.{Assert, Test}
import org.scalatest.junit.JUnitSuite
import org.springframework.http.HttpStatus
import org.springframework.mock.web.MockHttpServletResponse
import us.hexcoder.twirl.view.TwirlView

/**
 * Created by 67726e on 3/11/2015.
 */
class RedirectRendererTest extends JUnitSuite {
    @Test
    def testRender(): Unit = {
        val response = new MockHttpServletResponse

        new RedirectRenderer().render(TwirlView.redirect("/dashboard"), response)

        Assert.assertEquals("It should have a location of dashboard", "/dashboard", response.getHeader("location"))
        Assert.assertEquals(s"It should have a status of ${HttpStatus.FOUND}",
            HttpStatus.FOUND.value(), response.getStatus)
    }

    @Test(expected = classOf[IllegalArgumentException])
    def testRenderWrongType(): Unit = {
        new RedirectRenderer().render(TwirlView.empty(), new MockHttpServletResponse)
    }

    @Test(expected = classOf[IllegalArgumentException])
    def testRenderNullView(): Unit = {
        new RedirectRenderer().render(null, new MockHttpServletResponse)
    }

    @Test(expected = classOf[IllegalArgumentException])
    def testRenderNullResponse(): Unit = {
        new RedirectRenderer().render(TwirlView.redirect("/dashboard"), null)
    }
}
