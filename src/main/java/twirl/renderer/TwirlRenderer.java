package twirl.renderer;

import twirl.TwirlView;

import javax.servlet.http.HttpServletResponse;

/**
 * User: 67726e
 */
public interface TwirlRenderer {
	public void render(TwirlView view, HttpServletResponse response) throws Exception;
}
