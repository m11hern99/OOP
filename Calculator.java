import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
public class Calculator extends JFrame{
	Scanner kb = new Scanner(System.in);
	private JTextField input;
	private JTextField output;
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	public Calculator() {
		setTitle("Expression Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		JPanel tp1 = new JPanel();
		tp1.setLayout(new GridLayout(3,1));
		
		input = new JTextField("Enter Expression: ");
		input.setBackground(Color.YELLOW);
		Font font = new Font("Times New Roman", Font.BOLD, 20);
		input.setFont(font);
		tp1.add(input);

		output = new JTextField("Answer goes here.",40);
		output.setEditable(false);
		output.setBackground(Color.lightGray);
		output.setFont(font);
		tp1.add(output, BorderLayout.SOUTH);
		
		JTextField statLabel = new JTextField("Enter a correct arithmetic expression, with negative numbers enclosed in parentheses and no spaces." );
		statLabel.setEditable(false);
		statLabel.setBackground(Color.pink);
		statLabel.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		tp1.add(statLabel);
		add(tp1);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.green);
		buttonPanel.setLayout(new FlowLayout());

		JButton calcButton = new JButton("Calculate");
		calcButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String temp = input.getText();
				ExprEvaluator ex = new ExprEvaluator(temp);
				double ans = ex.evaluator();
				if(ans == (double)Math.round(ans)) {
					int intAns = (int)ans;
					output.setText("" + intAns );
			    }
			    else{
			    	output.setText("" + ans);
			    }
			}

		});
		buttonPanel.add(calcButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				input.setText("Enter Expression: ");
				output.setText("Answer goes here.");
			}

		});
		buttonPanel.add(resetButton);
		
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}
	public static void main(String[] args){
		Calculator calc = new Calculator();
		calc.setVisible(true);
	}
}