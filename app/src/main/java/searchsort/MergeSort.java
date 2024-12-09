package searchsort;

public class MergeSort extends Sort {
    /**
     * Sort the array arr using merge sort algorithm.
     */
    @Override
    public void sort(int[] arr) {
        int aux[] = new int[arr.length]; 
        mergesort(arr, aux, 0, arr.length - 1);
    }

    private void mergesort(int[] arr, int[] aux, int low, int high) {
        // Array is sorted if low is greater than high
        if(low >= high) {
            return;
        }
        int mid = (low + high) / 2; // Gets index of middle element
        mergesort(arr, aux, low, mid); // Sorts left side
        mergesort(arr, aux, mid + 1, high); // Sorts right side
        merge(arr, aux, low, mid, high); // Merges left and right
    }
    /*
     * Merge the two sorted arrays left and right into the array arr.
     */
    private void merge(int[] arr, int[] aux, int low, int mid, int high) {
        for(int k = low; k <= high; k++) { // Copy array
            aux[k] = arr[k];
        }

        int i = low; // Left side index
        int j = mid + 1; // Right side index
        for(int k = low; k <= high; k++) {
            if(i > mid) { // Left is exhausted 
                arr[k] = aux[j];
                j++;
            } else if(j > high) { // Right is exhausted
                arr[k] = aux[i]; 
                i++;
            } else if(aux[j] < aux[i]) { //Right element smaller than left
                arr[k] = aux[j];
                j++;
            } else {
                arr[k] = aux[i]; // Left element smaller than right
                i++;
            }
        }
    }
}
