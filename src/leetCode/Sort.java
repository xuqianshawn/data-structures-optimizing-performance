package leetCode;

public class Sort {
	private static void swap(int[] input, int n1, int n2)
	{
		int temp=input[n2];
		input[n2]=input[n1];
		input[n1]=temp;
		
	}
	private static int partition(int[] input, int low, int end)
	{
		int pivotIndex=low;
		int key=input[end];
		for(int i=low;i<end;i++)
		{
			if(input[i]<key)
			{
				//swap
				swap(input,i,pivotIndex);
				pivotIndex++;
			}
		}
		swap(input,end,pivotIndex);
		return pivotIndex;
	}

	private static void quickSort(int[] input, int low, int end) {
		if (end <low) {
			return;
		}
		int pivot = partition(input, low, end);
		quickSort(input, low, pivot-1);
		quickSort(input, pivot + 1, end);
	}

	public static int[] quickSort(int[] inputArr) {
		quickSort(inputArr, 0, inputArr.length - 1);
		return inputArr;
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
			swap(inputArr,i,minIndex);
		}
		return inputArr;
	}

	// best case O(n)
	public static int[] insertionSort(int[] inputArr) {

		for (int i = 1; i < inputArr.length; i++) {
			int j = i - 1;
			int key = inputArr[i];
			while (j >= 0 && inputArr[j] > key) {
				inputArr[j + 1] = inputArr[j];
				j--;
			}
			inputArr[j + 1] = key;

		}
		return inputArr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 17, 1, 8, 2, 5, 3, 11, 9 };
		int[] result = (quickSort(input));

		for (int i : result) {
			System.out.println(i);
		}

	}

}
