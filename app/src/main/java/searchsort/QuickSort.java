package searchsort;

public class QuickSort extends Sort {
    /**
     * Sort the array arr using quick sort algorithm.
     */
    @Override
    public void sort(int[] arr) {
        Util.shuffle(arr);
        quickSort(arr, 0, arr.length - 1);
    }

    /*
     * Sort the subarray arr[low..high] using quick sort algorithm.
     */
    private void quickSort(int[] arr, int low, int high) {
        if(high <= low) {
            return;
        }
        int p = partition(arr, low, high);
        quickSort(arr, low, p - 1);
        quickSort(arr, p + 1, high);
    }

    /*
     * Partition the subarray arr[low..high] using the last element as pivot.
     * Return the index of the pivot element after partition.
     */
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
}
