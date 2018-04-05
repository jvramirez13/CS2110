import java.awt.Graphics;

import javax.swing.JComponent;

public class InsertionSortComponent extends JComponent {
	private InsertionSort sorter;

	public InsertionSortComponent() {
		int[] values = ArrayUtil.randomIntArray(30, 300);
		sorter = new InsertionSort(values, this);
	}

	public void paintComponent(Graphics g)
	{
		sorter.draw(g);
	}

	public void startAnimation()
	{
		class AnimationRunnable implements Runnable {
			public void run() {
				try {
					sorter.sort();
				}
				catch (InterruptedException exception) {
				}
			}
		}
		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}


}


