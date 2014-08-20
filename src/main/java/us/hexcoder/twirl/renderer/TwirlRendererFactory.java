package us.hexcoder.twirl.renderer;

import com.google.common.net.MediaType;
import play.twirl.api.*;
import us.hexcoder.twirl.TwirlView;

/**
 * User: 67726e
 */
public final class TwirlRendererFactory {
	public static TwirlRenderer getRenderer(TwirlView view) {
		if (view.getRedirect() != null) {
			return new RedirectRenderer();
		} else if (view.getContent() != null) {
			return getBufferedContentRenderer(view.getContent());
		} else {
			return new DefaultRenderer();
		}
	}

	private static TwirlRenderer getBufferedContentRenderer(BufferedContent<?> content) {
		if (content instanceof Html) {
			return HTML_RENDERER;
		} else if (content instanceof Xml) {
			return XML_RENDERER;
		} else if (content instanceof Txt) {
			return TXT_RENDERER;
		} else if (content instanceof JavaScript) {
			return JS_RENDERER;
		} else {
			return new DefaultRenderer();
		}
	}

	private static final BufferedContentRenderer HTML_RENDERER = new BufferedContentRenderer(MediaType.HTML_UTF_8);
	private static final BufferedContentRenderer XML_RENDERER = new BufferedContentRenderer(MediaType.XML_UTF_8);
	private static final BufferedContentRenderer TXT_RENDERER = new BufferedContentRenderer(MediaType.PLAIN_TEXT_UTF_8);
	private static final BufferedContentRenderer JS_RENDERER = new BufferedContentRenderer(MediaType.JAVASCRIPT_UTF_8);
}
