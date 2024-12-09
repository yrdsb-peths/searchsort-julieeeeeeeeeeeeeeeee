package searchsort;

/**
 * The median is the middle value in an ordered integer list.
 * If the size of thelist is even,the median is the mean of the two
 * middle values.
 */
public class Median {
    /**
     * Find the median of the array arr using QuickSort algorithm.
     */
    public double findQuick(int[] arr) {
        quickSort(arr, 0, arr.length - 1);

        double median = arr[arr.length/2];
        if(arr.length % 2 == 0) {
            median = (median + arr[arr.length/2 - 1]) / 2; 
        }
        return median;
    }

    private void quickSort(int[] arr, int low, int high) {
        if(high <= low) {
            return;
        }
        int p = partition(arr, low, high);
        quickSort(arr, low, p - 1);
        quickSort(arr, p + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high + 1;
        while(true) {
            while(arr[++i] < arr[low]) { //Find item on left to swap
                if(i == high) {
                    break;
                }
            }
            while(arr[--j] > arr[low]) { //Find item on right to swap
                if(j == low) {
                    break;
                }
            }
            if(i >= j) { //Check if pointers cross
                break;
            }
            Util.exch(arr, i, j); //Swap
        }
        Util.exch(arr, i, j); //Swap partitioning element
        return j; //Return index of item we know is in place
    }

    /**
     * Find the median of the array arr using MergeSort algorithm.
     */
    public double findMerge(int[] arr) {
        int[] aux = new int[arr.length];
        mergesort(arr, aux, 0, arr.length - 1);

        double median = arr[arr.length/2];
        if(arr.length % 2 == 0) {
            median = (median + arr[arr.length/2 - 1]) / 2;
        }
        return median;
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

    /**
     * Find the median of the array arr using InsertionSort algorithm.
     */
    public double findInsertion(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j - 1] > arr[j]) {
                    Util.exch(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
        
        double median = arr[arr.length/2];
        if(arr.length % 2 == 0) {
            median = (median + arr[arr.length/2 - 1]) / 2;
        }
        return median;
    }
}
