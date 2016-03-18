package yarmark.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Singleton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
