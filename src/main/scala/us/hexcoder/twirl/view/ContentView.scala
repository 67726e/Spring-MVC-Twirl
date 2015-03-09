package us.hexcoder.twirl.view

import com.google.common.net.MediaType
import org.springframework.http.HttpStatus
import play.twirl.api.BufferedContent

/**
 * Created by 67726e on 3/8/2015.
 */
case class ContentView[A <: BufferedContent[A]](bufferedContent: BufferedContent[A],
                                             status: HttpStatus,
                                             contentType: MediaType) extends TwirlView {
}

object ContentView {
    // TODO: Figure out how to derive MediaType by BufferedContent[A]
    def apply[A <: BufferedContent[A]](bufferedContent: BufferedContent[A], contentType: MediaType): ContentView[A] =
        ContentView[A](bufferedContent, HttpStatus.OK, contentType)

    def apply[A <: BufferedContent[A]](bufferedContent: BufferedContent[A], status: HttpStatus): ContentView[A] =
        ContentView(bufferedContent, status, MediaType.HTML_UTF_8)

    def apply[A <: BufferedContent[A]](bufferedContent: BufferedContent[A]): ContentView[A] =
        ContentView(bufferedContent, HttpStatus.OK)
}
