package searchsort;

public class InsertionSort {
    /**
     * Sort the array arr using insertion sort algorithm.
     */
    public static void sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j - 1] > arr[j]) { //compare next element one by one
                    Util.exch(arr, j, j - 1); //exchange
                } else {
                    break;
                }
            }
        }
    }
}
