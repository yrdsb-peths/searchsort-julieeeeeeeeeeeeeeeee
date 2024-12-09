package searchsort;

public class SelectionSort {
    /**
     * Sort the array arr using selection sort algorithm.
     */
    public static void sort(int[] arr) {
        for(int cur = 0; cur < arr.length - 1; cur++) {
            int min = findMin(arr, cur); //find min in current array
            Util.exch(arr, cur, min); //move to front 
        }
    }

    public static int findMin(int[] arr, int start) {
        int min = start;
        for(int i = min; i < arr.length; i++) {
            if(arr[i] < arr[min]) {
                min = i;
            }
        }

        return min;
    }
}
