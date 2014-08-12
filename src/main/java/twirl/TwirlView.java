package twirl;

import org.springframework.web.servlet.View;
import play.twirl.api.BufferedContent;
import twirl.renderer.TwirlRendererFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * User: 67726e
 */
public class TwirlView extends AbstractTwirlView implements View {
	public TwirlView() {
		super();
	}

	public TwirlView(Redirect redirect) {
		super(redirect);
	}

	public TwirlView(BufferedContent<?> content) {
		super(content);
	}

	@Override
	public String getContentType() {
		return null;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		TwirlRendererFactory.getRenderer(this).render(this, response);
	}
}
