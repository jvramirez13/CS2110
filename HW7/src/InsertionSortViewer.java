import java.awt.BorderLayout;

import javax.swing.JFrame;

public class InsertionSortViewer {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 400;
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final InsertionSortComponent component1 = new InsertionSortComponent();
		frame.add(component1, BorderLayout.CENTER);
		
		frame.setVisible(true);
		component1.startAnimation();

	}

}