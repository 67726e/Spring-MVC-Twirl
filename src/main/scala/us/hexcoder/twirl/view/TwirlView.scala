package us.hexcoder.twirl.view

import java.util
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}

import org.springframework.http.HttpStatus
import org.springframework.web.servlet.view.AbstractUrlBasedView
import play.twirl.api.BufferedContent
import us.hexcoder.twirl.render.RendererFactory

/**
 * Created by 67726e on 3/8/2015.
 */
abstract class TwirlView extends AbstractUrlBasedView {
    override def renderMergedOutputModel(model: util.Map[String, AnyRef], request: HttpServletRequest, response: HttpServletResponse): Unit = {
        RendererFactory.getRenderer(this).render(this, response)
    }
}

object TwirlView {
    def redirect(location: String): RedirectView = RedirectView(location)
    def empty(): EmptyView = EmptyView()
    def ok[A <: BufferedContent[A]](content: BufferedContent[A]): ContentView[A] = ContentView[A](content, HttpStatus.OK)
    def error[A <: BufferedContent[A]](content: BufferedContent[A]): ContentView[A] = ContentView[A](content, HttpStatus.INTERNAL_SERVER_ERROR)
    def badRequest[A <: BufferedContent[A]](content: BufferedContent[A]): ContentView[A] = ContentView[A](content, HttpStatus.BAD_REQUEST)
    def forbidden[A <: BufferedContent[A]](content: BufferedContent[A]): ContentView[A] = ContentView[A](content, HttpStatus.FORBIDDEN)
}
