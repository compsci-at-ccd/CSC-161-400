import java.util.Arrays;

class Binary {
	public static int search(int array[], int start, int end, int element_to_find) {
		if ( end >= start ) {
			int mid = start + (end - start)/2;
			if ( array[mid] == element_to_find )
				return mid;
                	if ( array[mid] > element_to_find )
				return search(array, start, mid-1, element_to_find);
			return search( array, mid+1, end, element_to_find );
		}

		return -1;
	}

	public static void main(String args[]) {
		final int[] array = new int[] { 1,  2,  3,  5,  8,  13,  21,  34,  55,  89 };
		final int findme = 4;
		
		int result = Binary.search(array, 0, array.length-1, findme);
		
		System.out.print("In array: " + Arrays.toString(array) + " element " + findme);
		if (result == -1)
			System.out.println(" was not present.");
		else
			System.out.println(" was found at index " + result + ". ");
	}
}
