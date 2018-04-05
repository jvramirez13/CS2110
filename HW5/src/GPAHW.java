import java.awt.*;

import javax.swing.*;


public class GPAHW extends JFrame {
	JPanel title;
	JLabel courseLabel;
	JLabel titleLabel;
	JLabel summaryLabel;
	


	public GPAHW() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		this.setSize(width, height);
		title = new JPanel();
		title.add(courseLabel, BorderLayout.WEST);
		title.add(titleLabel, BorderLayout.CENTER);
		title.add(summaryLabel, BorderLayout.EAST);
		this.add(title, BorderLayout.NORTH);
		
		
		courseLabel = new JLabel("COURSES");
		titleLabel = new JLabel("GPA Calculator");
		summaryLabel = new JLabel("SUMMARY");




		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new GPAHW();
	}
}
