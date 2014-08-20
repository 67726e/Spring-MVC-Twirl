package us.hexcoder.twirl.renderer;

import us.hexcoder.twirl.TwirlView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Glenn Nelson
 *
 * The default renderer returns no content and a 204 response indicating that the response was empty.
 */
public class DefaultRenderer implements TwirlRenderer {
	private static final int NO_CONTENT = 204;

	@Override
	public void render(TwirlView view, HttpServletResponse response) throws Exception {
		// We have no content to respond with
		response.setStatus(NO_CONTENT);
	}
}
