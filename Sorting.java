package datastruct;

public class Sorting {
	public void selectionSorting(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int minIndex = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minIndex = j;
				}

				int temp = arr[i];
				arr[i] = min;
				arr[minIndex] = temp;
			}
		}
	}

	public void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			boolean swapped = false;
			for (int j = 0; j < (arr.length - 1) - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swapped = true;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

	public void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
				} else {
					break;
				}
			}
		}
	}
}
