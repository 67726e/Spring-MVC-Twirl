package us.hexcoder.twirl;

/**
 * @author Glenn Nelson
 *
 * Class used to indicate a redirect in conjunction with a TwirlView.
 * @see us.hexcoder.twirl.TwirlView
 */
public class Redirect {
	private String url;

	public Redirect(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
