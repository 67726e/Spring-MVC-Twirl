package us.hexcoder.twirl.render

import org.junit.{Assert, Test}
import org.scalatest.junit.JUnitSuite
import org.springframework.http.HttpStatus
import org.springframework.mock.web.MockHttpServletResponse
import us.hexcoder.twirl.view.TwirlView

/**
 * Created by 67726e on 3/11/2015.
 */
class EmptyRendererTest extends JUnitSuite {
    @Test
    def testRender(): Unit = {
        val response = new MockHttpServletResponse

        new EmptyRenderer().render(TwirlView.empty(), response)

        Assert.assertEquals(s"It should have a status of ${HttpStatus.NO_CONTENT}", HttpStatus.NO_CONTENT.value(), response.getStatus)
    }

    @Test(expected = classOf[IllegalArgumentException])
    def testRenderWrongType(): Unit = {
        new EmptyRenderer().render(TwirlView.redirect("/dashboard"), new MockHttpServletResponse)
    }

    @Test(expected = classOf[IllegalArgumentException])
    def testRenderNullView(): Unit = {
        new EmptyRenderer().render(null, new MockHttpServletResponse)
    }

    @Test(expected = classOf[IllegalArgumentException])
    def testRenderNullResponse(): Unit = {
        new EmptyRenderer().render(TwirlView.empty(), null)
    }
}
