public class SortingHat {
	// Bubble Sort
	public static void bubbleSort(String[] list) {
		boolean sorted = false;
		for (int top = list.length - 1; top > 0 && sorted == false; top--) {
			sorted = true;
			for (int i = 0; i < top; i++) {
				if (list[i].compareTo(list[i + 1]) > 0) {
					sorted = false; // a swap was required
					String temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
			}
		}
	}

	// Insertion Sort
	public static void insertSort(double[] list) {
		for (int top = 1; top < list.length; top++) {
			double item = list[top]; // temporary storage of item
			int i = top;
			while (i > 0 && item < list[i - 1]) {
				// shift larger items to the right by one
				list[i] = list[i - 1];
				// prepare to check the next item to the left
				i--;
			}
			list[i] = item; // put sorted item in open location
		}
	}

	// Merge Sort
	public static void mergeSort(int[] a) {
		int[] tmpArray = new int[a.length];
		mergeSort(a, tmpArray, 0, a.length - 1);
	}

	private static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(a, tmpArray, left, center);
			mergeSort(a, tmpArray, center + 1, right);
			merge(a, tmpArray, left, center + 1, right);
		}
	}

	/**
	 * Internal method that merges two sorted halves of a subarray.
	 * 
	 * @param a        an array of int items.
	 * @param tmpArray an array to place the merged result.
	 * @param leftPos  the left-most index of the subarray.
	 * @param rightPos the index of the start of the second half.
	 * @param rightEnd the right-most index of the subarray.
	 */
	private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		// Main loop
		while (leftPos <= leftEnd && rightPos <= rightEnd) {
			if (Integer.compare(a[leftPos], a[rightPos]) <= 0) {
				tmpArray[tmpPos++] = a[leftPos++];
			} else {
				tmpArray[tmpPos++] = a[rightPos++];
			}
		}

		while (leftPos <= leftEnd) { // Copy rest of first half
			tmpArray[tmpPos++] = a[leftPos++];
		}
		while (rightPos <= rightEnd) { // Copy rest of right half
			tmpArray[tmpPos++] = a[rightPos++];
		}

		// Copy tmpArray back
		for (int i = 0; i < numElements; i++, rightEnd--) {
			a[rightEnd] = tmpArray[rightEnd];
		}
	}

	// Quick Sort
	public int partition(int[] arr, int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}

		return i;
	}

	public void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);
	}

	// Selection Sort
	public static void selectSort(double[] list) {
		for (int top = list.length - 1; top > 0; top--) {
			int largeLoc = 0; // location of largest element
			// assume list[0] is largest to start
			for (int i = 1; i <= top; i++) // check list[1] to list[top]
			{
				if (list[i] > list[largeLoc]) {
					largeLoc = i;
				}
			}
			double temp = list[top]; // temporary storage
			list[top] = list[largeLoc];
			list[largeLoc] = temp;
		}
	}
}
