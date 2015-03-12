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
		if (view == null) throw new IllegalArgumentException("The TwirlView cannot be null");
		if (response == null) throw new IllegalArgumentException("The HttpServletResponse cannot be null");
		if (!(view instanceof RedirectView))
			throw new IllegalArgumentException(String.format("The TwirlView %s is not of type RedirectView", view.getClass()));

		response.sendRedirect(((RedirectView) view).location());
	}
}
