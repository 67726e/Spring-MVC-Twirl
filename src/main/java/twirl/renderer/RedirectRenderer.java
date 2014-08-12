package twirl.renderer;

import twirl.TwirlView;

import javax.servlet.http.HttpServletResponse;

/**
 * User: 67726e
 */
public class RedirectRenderer implements TwirlRenderer {
	@Override
	public void render(TwirlView view, HttpServletResponse response) throws Exception {
		response.sendRedirect(view.getRedirect().getUrl());
	}
}
