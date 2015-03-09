package us.hexcoder.twirl.view

import com.google.common.net.MediaType
import org.springframework.http.HttpStatus
import play.twirl.api._

/**
 * Created by 67726e on 3/8/2015.
 */
case class ContentView[A <: BufferedContent[A]](bufferedContent: BufferedContent[A],
                                             status: HttpStatus,
                                             contentType: MediaType) extends TwirlView {
}

object ContentView {
    def apply[A <: BufferedContent[A]](bufferedContent: BufferedContent[A], contentType: MediaType): ContentView[A] =
        ContentView[A](bufferedContent, HttpStatus.OK, contentType)

    def apply[A <: BufferedContent[A]](bufferedContent: BufferedContent[A], status: HttpStatus): ContentView[A] =
        ContentView(bufferedContent, status, toContentType(bufferedContent))

    def apply[A <: BufferedContent[A]](bufferedContent: BufferedContent[A]): ContentView[A] =
        ContentView(bufferedContent, HttpStatus.OK)

    private def toContentType[A <: BufferedContent[A]](content: BufferedContent[A]) = {
        content match {
            case _: Html => MediaType.HTML_UTF_8
            case _: JavaScript => MediaType.JAVASCRIPT_UTF_8
            case _: Xml => MediaType.XML_UTF_8
            case _: Txt => MediaType.PLAIN_TEXT_UTF_8
        }
    }
}
