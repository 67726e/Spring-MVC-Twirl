package us.hexcoder.twirl.render

import us.hexcoder.twirl.view._

/**
 * Created by 67726e on 3/9/2015.
 */
object RendererFactory {
    def getRenderer(view: TwirlView): TwirlRenderer = {
        view match {
            case EmptyView() => new EmptyRenderer
            case RedirectView(_) => new RedirectRenderer
            case ContentView(_, _, _) => new BufferedContentRenderer
            case _ => new EmptyRenderer
        }
    }
}
