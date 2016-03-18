package yarmark.paint;

import java.awt.BorderLayout;
import java.awt.Container;

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

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame frame = injector.getInstance(PaintFrame.class);
		frame.setVisible(true);
	}
}
