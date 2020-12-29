import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class HourglassTester {
	public static void main(String[] args) {

		JFrame frame = new JFrame("Hourglass");

		final Moveable shape = new Hourglass(0, 0, 300);

		ShapeIcon icon = new ShapeIcon(shape, 400, 400);

		final JLabel label = new JLabel(icon);
		frame.setLayout(new FlowLayout());
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		final int DELAY = 20; 
		Timer t = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				label.repaint();
				shape.translate(1, 1);
			}
		});
		t.start();
	}

}