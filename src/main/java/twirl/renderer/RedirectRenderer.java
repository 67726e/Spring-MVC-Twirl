package twirl.renderer;

import twirl.TwirlView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 67726e
 *
 * Sends a 301 redirect response to the client with the URL designated in the TwirlView's Redirect object.
 * @see twirl.Redirect
 */
public class RedirectRenderer implements TwirlRenderer {
	@Override
	public void render(TwirlView view, HttpServletResponse response) throws Exception {
		response.sendRedirect(view.getRedirect().getUrl());
	}
}
