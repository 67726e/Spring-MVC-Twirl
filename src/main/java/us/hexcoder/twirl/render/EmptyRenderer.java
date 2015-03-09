package us.hexcoder.twirl.render;

import org.springframework.http.HttpStatus;
import us.hexcoder.twirl.view.TwirlView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 67726e on 3/9/2015.
 */
public class EmptyRenderer implements TwirlRenderer {
	@Override
	public void render(TwirlView view, HttpServletResponse response) throws Exception {
		response.setStatus(HttpStatus.NO_CONTENT.value());
	}
}
