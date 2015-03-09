package us.hexcoder.twirl.render;

import us.hexcoder.twirl.view.RedirectView;
import us.hexcoder.twirl.view.TwirlView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 67726e on 3/9/2015.
 */
public class RedirectRenderer implements TwirlRenderer {
	@Override
	public void render(TwirlView view, HttpServletResponse response) throws Exception {
		if (view instanceof RedirectView) {
			response.sendRedirect(((RedirectView) view).location());
		} else {
			throw new IllegalArgumentException(String.format("TwirlView %s is not of type RedirectView", view.getClass()));
		}
	}
}
