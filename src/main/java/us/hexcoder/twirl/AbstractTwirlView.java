package us.hexcoder.twirl;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import play.twirl.api.*;

/**
 * User: 67726e
 */
public abstract class AbstractTwirlView extends AbstractUrlBasedView {
	protected final Redirect redirect;
	protected final BufferedContent<?> content;

	public AbstractTwirlView() {
		this.redirect = null;
		this.content = null;
	}

	public AbstractTwirlView(Redirect redirect) {
		this.redirect = redirect;
		this.content = null;
	}

	public AbstractTwirlView(BufferedContent<?> content) {
		this.redirect = null;
		this.content = content;
	}

	public Redirect getRedirect() {
		return redirect;
	}

	public BufferedContent<?> getContent() {
		return content;
	}
}
