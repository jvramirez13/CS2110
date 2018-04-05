import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JComponent;

public class BubbleSort {

	// This array is being sorted
	private int[] a;
	// These instance variables are needed for drawing
	private int markedPosition = -1;
	private int alreadySorted = -1;

	private Lock sortStateLock;

	// The component is repainted when the animation is paused
	private JComponent component;

	private static final int DELAY = 100;

	public BubbleSort(int[] anArray, JComponent aComponent) {
		a = anArray;
		sortStateLock = new ReentrantLock();
		component = aComponent;
	}

	public void sort() throws InterruptedException {
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
		}
		for (int i = 0; i < a.length - j; i++)
		{
			sortStateLock.lock();
			try
			{
				if (a[i] > a[i + 1]) {
					tmp = a[i];
					a[i] = a[i+1];
					a[i + 1] = tmp;
					swapped = true;
				}
			}
			finally
			{
				sortStateLock.unlock();
			}
			pause(2);
		}
	}


	public void draw(Graphics g)
	{
		sortStateLock.lock();
		try
		{
			int deltaX = component.getWidth() / a.length;
			for (int i = 0; i < a.length; i++)
			{
				if (i == markedPosition)
				{
					g.setColor(Color.RED);
				}
				else if (i <= alreadySorted)
				{
					g.setColor(Color.BLUE);
				}
				else
				{
					g.setColor(Color.BLACK);
				}
				g.drawLine(i * deltaX, 0, i * deltaX, a[i]);
			}
		}
		finally
		{
			sortStateLock.unlock();
		}
	}

	/**
	 Pauses the animation.
	 @param steps the number of steps to pause
	 */
	public void pause(int steps)
			throws InterruptedException
	{
		component.repaint();
		Thread.sleep(steps * DELAY);
	}
}
