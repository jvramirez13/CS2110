import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class NewFrame extends JFrame {
	
	private JButton button;
	private JPanel panel;
	private static Color[] colors = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.MAGENTA, Color.ORANGE, Color.RED};

	
	public NewFrame() {
		this.setTitle("New Frame Demo");
		this.setBounds(600,300,300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button = new JButton("Click Here!");
		panel = new JPanel();
		button.addActionListener(new ChangeColor());
		panel.add(button);
		this.add(panel);
		this.setVisible(true);
	}
	
	private class ChangeColor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Random rand = new Random();
			int x = rand.nextInt(colors.length);
			panel.setBackground(colors[x]);
			
		}
		
	}
	public static void main(String[] args) {
		new NewFrame();

	}

}
