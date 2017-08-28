package leetCode;

public class Sort {
	private static void swap(int[] input, int n1, int n2) {
		int temp = input[n2];
		input[n2] = input[n1];
		input[n1] = temp;

	}

	private static int partition(int[] input, int low, int end) {
		int pivotIndex = low;
		int key = input[end];
		for (int i = low; i < end; i++) {
			if (input[i] < key) {
				// swap
				swap(input, i, pivotIndex);
				pivotIndex++;
			}
		}
		swap(input, end, pivotIndex);
		return pivotIndex;
	}

	private static void quickSort(int[] input, int low, int end) {
		if (end <= low) {
			return;
		}
		int pivot = partition(input, low, end);
		quickSort(input, low, pivot - 1);
		quickSort(input, pivot + 1, end);
	}

	public static void quickSort(int[] inputArr) {
		quickSort(inputArr, 0, inputArr.length - 1);
		// return inputArr;
	}

	public static void merge(int[] inputArr, int[] temp, int low, int mid, int high) {
		int templeft = low;
		int tempright = mid;

		int tempIndex = low;
		while (templeft <= mid && tempright <= high) {
			if (inputArr[templeft] < inputArr[tempright]) {
				temp[tempIndex] = inputArr[templeft];
				templeft++;
			} else {
				temp[tempIndex] = inputArr[tempright];
				tempright++;
			}
			tempIndex++;
		}
		// copy whatever is left from the left side
		while (templeft < mid) {
			temp[tempIndex] = inputArr[templeft];
			templeft++;
			tempIndex++;
		}
		// copy whatever is left from the right side
		while (tempright < high) {
			temp[tempIndex] = inputArr[tempright];
			tempright++;
			tempIndex++;
		}
		for (int i = low; i <= high; i++) {
			inputArr[i] = temp[i];
		}
	}

	public static void mergeSort(int[] inputArr, int[] temp, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		mergeSort(inputArr, temp, low, mid-1);
		mergeSort(inputArr, temp, mid+1, high);
		merge(inputArr, temp, low, mid , high);
	}

	public static void mergeSort(int[] inputArr) {
		int[] temp = new int[inputArr.length];
		mergeSort(inputArr, temp, 0, inputArr.length - 1);
	}

	// simplest approach
	public static int[] selectionSort(int[] inputArr) {
		int size = inputArr.length;
		int temp = 0;
		for (int i = 0; i < size; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int j = i; j < size; j++) {
				if (inputArr[j] < min) {
					min = inputArr[j];
					minIndex = j;
				}
			}
			// swap
			swap(inputArr, i, minIndex);
		}
		return inputArr;
	}

	// best case O(n)
	public static int[] insertionSort(int[] input) {

		for (int i = 1; i < input.length; i++) {
			int j = i;
			int pivot = input[j];
			while (j > 0 && input[j - 1] > pivot) {
				input[j] = input[j - 1];
				j--;
			}
			input[j] = pivot;
		}
		return input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 17, 1, 8, 2, 5, 3, 11, 9 };
		mergeSort(input);

		for (int i : input) {
			System.out.println(i);
		}

	}

}
