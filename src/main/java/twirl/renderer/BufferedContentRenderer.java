package twirl.renderer;

import com.google.common.net.MediaType;
import twirl.TwirlView;

import javax.servlet.http.HttpServletResponse;

/**
 * User: 67726e
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
