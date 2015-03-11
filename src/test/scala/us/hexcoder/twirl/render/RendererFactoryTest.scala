package us.hexcoder.twirl.render

import org.junit.{Assert, Test}
import org.scalatest.junit.JUnitSuite
import us.hexcoder.twirl.view.{ContentView, EmptyView, RedirectView}

/**
 * Created by 67726e on 3/9/2015.
 */
class RendererFactoryTest extends JUnitSuite {
    @Test
    def testGetRendererWithEmptyView() = {
        val renderer = RendererFactory.getRenderer(EmptyView())

        Assert.assertNotNull("A renderer should be returned", renderer)
        Assert.assertEquals("It should be of type EmptyRenderer", renderer.getClass, classOf[EmptyRenderer])
    }

    @Test
    def testGetRendererWithContentView() = {
        val renderer = RendererFactory.getRenderer(ContentView(html.index()))

        Assert.assertNotNull("A renderer should be returned", renderer)
        Assert.assertEquals("It should be of type BufferedContentRenderer", renderer.getClass, classOf[BufferedContentRenderer])
    }

    @Test
    def testGetRendererWithRedirectView() = {
        val renderer = RendererFactory.getRenderer(RedirectView("/"))

        Assert.assertNotNull("A renderer should be returned", renderer)
        Assert.assertEquals("It should be of type RedirectRenderer", renderer.getClass, classOf[RedirectRenderer])
    }

    @Test
    def testGetRendererWithNull() = {
        val renderer = RendererFactory.getRenderer(null)

        Assert.assertNotNull("A renderer should be returned", renderer)
        Assert.assertEquals("It should be of type EmptyRenderer", renderer.getClass, classOf[EmptyRenderer])
    }
}
