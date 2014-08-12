package twirl.renderer;

import twirl.TwirlView;

import javax.servlet.http.HttpServletResponse;

/**
 * User: 67726e
 */
public class DefaultRenderer implements TwirlRenderer {
	private static final int NO_CONTENT = 204;

	@Override
	public void render(TwirlView view, HttpServletResponse response) throws Exception {
		// We have no content to respond with
		response.setStatus(NO_CONTENT);
	}
}
