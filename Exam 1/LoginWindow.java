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

public class LoginWindow extends JFrame {
	Scanner kb = new Scanner(System.in);
	private JTextField Username;
	private JTextField Status;
	private JTextField Password;
	private String user;
	private String pass;

	public LoginWindow() {
		setTitle("Sign in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel tp1 = new JPanel();
		tp1.		setBackground(Color.decode("#FFFB92"));

		tp1.setLayout(new GridLayout(3, 2));
		Font font = new Font("Times New Roman", Font.BOLD, 20);

		JTextField userLabel = new JTextField("User");
		userLabel.setEditable(false);
		userLabel.setBackground(Color.WHITE);
		userLabel.setFont(font);
		tp1.add(userLabel);
		
		Username = new JTextField(15);
		Username.setBackground(Color.WHITE);
		Username.setFont(font);
		tp1.add(Username);
	
		JTextField passLabel = new JTextField("Password");
		passLabel.setEditable(false);
		passLabel.setBackground(Color.WHITE);
		passLabel.setFont(font);
		tp1.add(passLabel);
		
		Password = new JTextField(15);
		Password.setBackground(Color.WHITE);
		Password.setFont(font);
		tp1.add(Password);
		
		JTextField statLabel = new JTextField("Status");
		statLabel.setEditable(false);
		statLabel.setBackground(Color.WHITE);
		statLabel.setFont(font);
		tp1.add(statLabel);
		
		Status = new JTextField(15);
		Status.setEditable(false);
		Status.setBackground(Color.WHITE);
		Status.setFont(font);
		tp1.add(Status);
		
		add(tp1, BorderLayout.NORTH);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.decode("#FFFB92"));
		buttonPanel.setLayout(new FlowLayout());
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int u = 0;
				int p = 0;
				user = Username.getText();
				pass = Password.getText();
				for (int i = 0; i < user.length(); i++) {
					u = u + (int) user.charAt(i);
				}
				for (int i = 0; i < pass.length(); i++) {
					p = p + (int) pass.charAt(i);
				}
				if (u == p) {
					Username.setText("");
					Password.setText("");
					Status.setText("Welcome!");
				} else {
					Username.setText("");
					Password.setText("");
					Status.setText("Sign-in rejected.");
				}
			}
		});
		buttonPanel.add(loginButton);
		add(buttonPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public static void main(String[] args) {
		LoginWindow a = new LoginWindow();
		a.setVisible(true);
	}
}
