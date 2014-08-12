package twirl.renderer;

import twirl.TwirlView;

import javax.servlet.http.HttpServletResponse;

/**
 * User: 67726e
 */
public class DefaultRenderer implements TwirlRenderer {
	@Override
	public void render(TwirlView view, HttpServletResponse response) throws Exception {
		// TODO: Return empty Content-Type?
	}
}
