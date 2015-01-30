package us.hexcoder.twirl.renderer;

import com.google.common.net.MediaType;
import us.hexcoder.twirl.TwirlView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Glenn Nelson
 *
 * The renderer used to render the Twirl template to the client, along with the designated Content-Type for the template.
 */
public final class BufferedContentRenderer implements TwirlRenderer {
	private final MediaType mediaType;

	protected BufferedContentRenderer(MediaType mediaType) {
		this.mediaType = mediaType;
	}

	@Override
	public void render(TwirlView view, HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType(mediaType.toString());

		try (BufferedReader reader = new BufferedReader(new StringReader(view.getContent().toString()));
			 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()))) {
			String line;

			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.write("\r\n");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
