import java.awt.BorderLayout;

import javax.swing.*;

public class SimpleFrame {
	
	private JFrame frame;
	private JLabel label;
	private JButton button;
	private JTextField text;
	
	public SimpleFrame() {
		frame = new JFrame();
		frame.setTitle("Frame Demo");
		frame.setBounds(600, 300, 300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//if you dont put this, the program will still run in backrground when you close it
		
		label = new JLabel("How are you today?");
		button = new JButton("Click Here!");
		text = new JTextField(20);
		
		frame.add(label, BorderLayout.NORTH);
		frame.add(button, BorderLayout.CENTER);
		frame.add(text,  BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new SimpleFrame();

	}

}
