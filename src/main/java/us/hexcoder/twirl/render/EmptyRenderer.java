package us.hexcoder.twirl.render;

import org.springframework.http.HttpStatus;
import us.hexcoder.twirl.view.EmptyView;
import us.hexcoder.twirl.view.TwirlView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 67726e on 3/9/2015.
 */
public class EmptyRenderer implements TwirlRenderer {
	@Override
	public void render(TwirlView view, HttpServletResponse response) throws Exception {
		if (view == null) throw new IllegalArgumentException("The TwirlView cannot be null");
		if (response == null) throw new IllegalArgumentException("The HttpServletResponse cannot be null");
		if (!(view instanceof EmptyView))
			throw new IllegalArgumentException(String.format("The TwirlView %s is not of type EmptyView", view.getClass()));

		response.setStatus(HttpStatus.NO_CONTENT.value());
	}
}
