import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ClockTester {
	public static void main(String arg[]) {
		JFrame frame = new JFrame();
		frame.setTitle("Clock");
		ClockIcon shape = new ClockIcon(0,0,100,0,0,0);
		ShapeIcon icon = new ShapeIcon(shape, 600,600);
		JLabel label = new JLabel(icon);
		label.setBackground(Color.pink);
		label.setOpaque(true);
		frame.setLayout(new BorderLayout());
		frame.add(label,BorderLayout.NORTH);
		
		
		final int DELAY = 1000;
		Timer t = new Timer(DELAY, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				shape.translate(1, 0);
				label.repaint();
				}
			});
		t.start();
		
		JPanel tp1 = new JPanel();
		tp1.setLayout(new GridLayout(1,4));
		tp1.setBackground(Color.pink);
		
		JTextField hour = new JTextField(("Starting Hour"),9);
		hour.setBackground(Color.white);
		Font font = new Font("Times New Roman", Font.PLAIN, 15);
		hour.setFont(font);
		tp1.add(hour);
		
		JTextField minute = new JTextField(("Starting Minute"),9);
		minute.setBackground(Color.white);
		minute.setFont(font);
		tp1.add(minute);
		
		JTextField second = new JTextField(("Starting Second"),9);
		second.setBackground(Color.white);
		second.setFont(font);
		tp1.add(second);

		JButton setButton = new JButton("Set");
		setButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.stop();
				String h = hour.getText();
				String m = minute.getText();
				String s = second.getText();
				int h2;
				int m2;
				int s2;
				try { 
			       Integer.parseInt(h); 
			    }
				catch(NumberFormatException x) { 
					hour.setText("Try again");
				}
				try { 
					Integer.parseInt(m); 
				}
				catch(NumberFormatException x) { 
					minute.setText("Try again");
				}
				try { 
					Integer.parseInt(s);
				}
				catch(NumberFormatException x) { 
					second.setText("Try again");
				}
				h2 = Integer.parseInt(h);
				m2 = Integer.parseInt(m);
				s2 = Integer.parseInt(s);
				shape.setH(h2);
				shape.setM(m2);
				shape.setCount(s2);
				t.start();
			}
			
		});
		tp1.add(setButton);
			

		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				t.stop();
				hour.setText("Starting Hour");
				minute.setText("Starting Minute");
				second.setText("Starting Minute");
				shape.setReset();
				t.start();
			}
			
		});
		tp1.add(resetButton);
		
		frame.add(tp1, BorderLayout.PAGE_END);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}