
public class RecursiveBinarySearch {

	public static int recursiveBinarySearch(int[] array, int target) {
		int start = array[0];
		int end = array[array.length];
		if (start < end) {
			int mid = start + (end - start) / 2;  
			if (target < array[mid]) {
				return recursiveBinarySearch(array, target);
			} else if (target > array[mid]) {
				return recursiveBinarySearch(array, target);
			} else {
				return mid;
			}
		}
		return -(start + 1);
	}
	
}



