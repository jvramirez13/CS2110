import java.awt.BorderLayout;

import javax.swing.JFrame;

public class AllSortViewer {

	public static void main(String[] args) {
			JFrame frame = new JFrame();

			final int FRAME_WIDTH = 900;
			final int FRAME_HEIGHT = 1200;

			frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			final SelectionSortComponent component = new SelectionSortComponent();
			final InsertionSortComponent component1 = new InsertionSortComponent();
			final BubbleSortComponent component2 = new BubbleSortComponent();
			frame.add(component, BorderLayout.WEST);
			frame.add(component1, BorderLayout.CENTER);
			frame.add(component2, BorderLayout.EAST);

			frame.setVisible(true);
			component2.startAnimation();
			component1.startAnimation();
			component.startAnimation();

	}

}
