//John Ramirez jr5xw
import java.util.Arrays;

public class insertion {
	public static void insertionSort(int[] a) {
		{
			for (int i = 1; i < a.length; i++)
			{
				int next = a[i];
				int j = i;
				while (j > 0 && a[j - 1] > next) {
					a[j] = a[j - 1];
					j--;
				}
				a[j] = next;
			}
		}
	}

	public static void main(String[] args) {
		int[] newArray = new int[5];
		newArray[0] = 12;
		newArray[1] = 3;
		newArray[2] = 11;
		newArray[3] = 9;
		newArray[4] = 1;
		System.out.println(Arrays.toString(newArray));
		insertionSort(newArray);
		System.out.println(Arrays.toString(newArray));

	}

}
