package us.hexcoder.twirl.render;

import us.hexcoder.twirl.view.ContentView;
import us.hexcoder.twirl.view.TwirlView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author Glenn Nelson
 *
 * The renderer used to render the Twirl template to the client, along with the designated Content-Type for the template.
 */
public final class BufferedContentRenderer implements TwirlRenderer {
	@Override
	public void render(TwirlView view, HttpServletResponse response) throws Exception {
		if (view == null) throw new IllegalArgumentException("The RenderableView cannot be null");
		if (response == null) throw new IllegalArgumentException("The HttpServletResponse cannot be null");
		if (!(view instanceof ContentView))
			throw new IllegalArgumentException(String.format("The TwirlView %s is not of type ContentView", view.getClass()));

		ContentView content = (ContentView) view;

		response.setCharacterEncoding("UTF-8");
		response.setContentType(content.contentType().toString());

		try (BufferedReader reader = new BufferedReader(new StringReader(content.bufferedContent().toString()));
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
