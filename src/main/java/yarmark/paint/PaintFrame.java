package yarmark.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.inject.Singleton;
import javax.swing.JFrame;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

@Singleton
public class PaintFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	@Inject
	public PaintFrame(Canvas canvas, PaintToolbar toolbar) {
		setTitle("Paint Frame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		container.add(canvas, BorderLayout.CENTER);
		container.add(toolbar, BorderLayout.NORTH);
	}

	public static void main(String[] args) throws SecurityException, IOException {

		// this should change all loggers in app to display messages from all
		// loggers fine and higher
		// passing in package to affect all
		// normal setting is info and above
		Logger logger = Logger.getLogger("yarmark.paint");
		logger.setLevel(Level.FINE);
		// handler handles where the messages are sent
		// can be logged to file, database
		// java also has email API to send emails about severe errors

		// Handler handler = new ConsoleHandler();

		Handler handler = new FileHandler("log.txt"); // logs to file in xml
		handler.setFormatter(new SimpleFormatter()); // to have it log in
														// strings, same as to
														// console
		handler.setLevel(Level.FINE);
		logger.addHandler(handler);

		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame frame = injector.getInstance(PaintFrame.class);
		frame.setVisible(true);
	}
}
