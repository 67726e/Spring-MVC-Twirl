package us.hexcoder.twirl.render

import com.google.common.net.MediaType
import org.junit.{Assert, Test}
import org.scalatest.junit.JUnitSuite
import org.springframework.http.HttpStatus
import org.springframework.mock.web.MockHttpServletResponse
import us.hexcoder.twirl.view.TwirlView

/**
 * Created by 67726e on 3/11/2015.
 */
class BufferedContentRendererTest extends JUnitSuite {
    def testRender(): Unit = {
        val response = new MockHttpServletResponse

        new BufferedContentRenderer().render(TwirlView.ok(html.index()), response)

        Assert.assertEquals(s"It should have a content-type of ${MediaType.HTML_UTF_8}", MediaType.HTML_UTF_8, response.getContentType)
        Assert.assertEquals(s"It should have a status of ${HttpStatus.OK}", HttpStatus.OK, response.getStatus)
    }

    @Test(expected = classOf[IllegalArgumentException])
    def testRenderWrongType(): Unit = {
        new BufferedContentRenderer().render(TwirlView.empty(), new MockHttpServletResponse)
    }

    @Test(expected = classOf[IllegalArgumentException])
    def testRenderNullView(): Unit = {
        new BufferedContentRenderer().render(null, new MockHttpServletResponse)
    }

    @Test(expected = classOf[IllegalArgumentException])
    def testRenderNullResponse(): Unit = {
        new BufferedContentRenderer().render(TwirlView.ok(html.index()), null)
    }
}
