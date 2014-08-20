package us.hexcoder.twirl.renderer;

import us.hexcoder.twirl.TwirlView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Glenn Nelson
 *
 * Interface for rendering a TwirlView based upon the contents of that TwirlView.
 */
public interface TwirlRenderer {
	public void render(TwirlView view, HttpServletResponse response) throws Exception;
}
