package us.hexcoder.twirl.view

import com.google.common.net.MediaType
import org.junit.{Assert, Test}
import org.scalatest.junit.JUnitSuite
import org.springframework.http.HttpStatus

/**
 * Created by 67726e on 3/11/2015.
 */
class TwirlViewTest extends JUnitSuite {
    @Test
    def testRedirect(): Unit = {
        val view = TwirlView.redirect("/dashboard")

        Assert.assertNotNull("A view should have been returned", view)
        Assert.assertEquals("It should have a location of /dashboard", "/dashboard", view.location)
    }

    @Test
    def testEmpty(): Unit = {
        val view = TwirlView.empty()

        Assert.assertNotNull("A view should have been returned", view)
        Assert.assertEquals(s"It should have a class of ${classOf[EmptyView]}", classOf[EmptyView], view.getClass)
    }

    @Test
    def testOk(): Unit = {
        val view = TwirlView.ok(html.index())

        Assert.assertNotNull("A view should have been returned", view)
        Assert.assertEquals(s"It should have a content-type of ${MediaType.HTML_UTF_8}", MediaType.HTML_UTF_8, view.contentType)
        Assert.assertEquals(s"It should have a status of ${HttpStatus.OK}", HttpStatus.OK, view.status)
    }

    @Test
    def testError(): Unit = {
        val view = TwirlView.error(js.application())

        Assert.assertNotNull("A view should have been returned", view)
        Assert.assertEquals(s"It should have a content-type of ${MediaType.JAVASCRIPT_UTF_8}", MediaType.JAVASCRIPT_UTF_8, view.contentType)
        Assert.assertEquals(s"It should have a status of ${HttpStatus.INTERNAL_SERVER_ERROR}", HttpStatus.INTERNAL_SERVER_ERROR, view.status)
    }

    @Test
    def testBadRequest(): Unit = {
        val view = TwirlView.badRequest(xml.test())

        Assert.assertNotNull("A view should have been returned", view)
        Assert.assertEquals(s"It should have a content-type of ${MediaType.XML_UTF_8}", MediaType.XML_UTF_8, view.contentType)
        Assert.assertEquals(s"It should have a status of ${HttpStatus.BAD_REQUEST}", HttpStatus.BAD_REQUEST, view.status)
    }

    @Test
    def testForbidden(): Unit = {
        val view = TwirlView.forbidden(txt.test())

        Assert.assertNotNull("A view should have been returned", view)
        Assert.assertEquals(s"It should have a content-type of ${MediaType.PLAIN_TEXT_UTF_8}", MediaType.PLAIN_TEXT_UTF_8, view.contentType)
        Assert.assertEquals(s"It should have a status of ${HttpStatus.FORBIDDEN}", HttpStatus.FORBIDDEN, view.status)
    }
}
