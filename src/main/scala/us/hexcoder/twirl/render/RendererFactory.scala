package us.hexcoder.twirl.render

import us.hexcoder.twirl.view._

/**
 * Created by 67726e on 3/9/2015.
 */
object RendererFactory {
    def getRenderer(view: TwirlView): TwirlRenderer = {
        if (view == null) throw new IllegalArgumentException("Cannot render a null view")

        view match {
            case EmptyView() => new EmptyRenderer
            case RedirectView(_) => new RedirectRenderer
            case ContentView(_, _, _) => new BufferedContentRenderer
            case default => throw new IllegalStateException(s"Unable to find renderer for view of type ${default.getClass}")
        }
    }
}
