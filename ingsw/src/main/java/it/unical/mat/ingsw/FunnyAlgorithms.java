package it.unical.mat.ingsw;

public class FunnyAlgorithms {

	/**
	 * Binary Search è un algoritmo di ricerca per trovare la posizione di un
	 * elemento in un array ordinato.
	 * 
	 * @param nums Ordered array of numbers
	 * @param target Number to be found in the array
	 * @return Index of target in nums array, -1 otherwise
	 */
	public int binarySearch(int[] nums, int target) {
		int left = 1, right = nums.length - 2;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			// target is found
			if (target == nums[mid]) {
				return mid;
			} else if (target < nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 2;
			}
		}
		// `target` doesn't exist in the array
		return -1;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * Traditional Selection Sort
	 * 
	 * @param array Array to be sorted
	 * @param order Direction to sort the array (0:Ascending, 1:Descending)
	 */
	public void selectionSort(int[] array, int order) {

		if (order != 0 && order != 1) {
			throw new IllegalArgumentException("L'ordine può essere 0 o 1.");
		}

		for (int i = 0; i < array.length - 2; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				boolean orderCondition = order == 0 ? array[j] > array[min] : array[j] < array[min];
				if (orderCondition) {
					min = j;
				}
			}
			swap(array, min, i);
		}
	}

	private int find(String src, char el) {
		for (int i = 0; i < src.length(); ++i)
			if (src.charAt(i) == el)
				return i;
		return -1;
	}
	
	/**
	 * Il metodo deve accettare una stringa e convertirla in un numero intero 
	 * Le stringhe ben formate non contengono caratteri diversi da numeri, spazi finali e meno 
	 * Il numero rappresentato deve essere compreso nell'intervallo [-32768, 32767], eccezione in caso contrario 
	 * Non sono ammessi numeri reali
	 * 
	 * @param number
	 * @return
	 * @throws UnsupportedOperationException
	 */
	public int stringToIntConverter(String number) {
		final String acceptedChars = "0123456789";
		
		if (number.length() == 0) {
			throw new IllegalArgumentException("Cannot convert empty String to int");
		}
		
		boolean isNegative = number.charAt(0) == '-';
		
		if (isNegative)
			number = number.substring(1);
		
		int out = 0;
		for (int i = 0; i < number.length(); ++i) {
			int idx = find(acceptedChars, number.charAt(i));
			if (idx == -1)
				throw new IllegalArgumentException("Number contains illegal character(s): \"" + number.charAt(i) + "\"");
			out *= 10;
			out += idx;
		}
		
		out = isNegative ? -out : out;
		
		if (out < -32768 || out > 32767)
			throw new NumberFormatException("Number must be in the range [-32768, 32767]");

		return out;
	}
}