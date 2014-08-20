package us.hexcoder.twirl.renderer;

import com.google.common.net.MediaType;
import us.hexcoder.twirl.TwirlView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Glenn Nelson
 *
 * The renderer used to render the Twirl template to the client, along with the designated Content-Type for the template.
 */
public final class BufferedContentRenderer implements TwirlRenderer {
	private final MediaType mediaType;

	protected BufferedContentRenderer(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	@Override
	public void render(TwirlView view, HttpServletResponse response) throws Exception {
		response.getOutputStream().print(view.getContent().toString());
		response.setContentType(mediaType.toString());
	}
}
