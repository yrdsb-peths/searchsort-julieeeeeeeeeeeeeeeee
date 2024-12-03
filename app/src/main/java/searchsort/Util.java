package searchsort;

import java.util.Random;

public class Util {
    /**
     * Shuffle the elements in the array arr using Fisher-Yates shuffle algorithm.
     */
    public static int[] shuffle(int[] arr, Long seed) {
        // Initialize a Random object with the given seed if provided
        Random random = (seed != null) ? new Random(seed) : new Random();

        // Implement the Fisher-Yates shuffle algorithm
        // To generate a random index between 0 and i (exclusive) use:
        // random.nextInt(i)
        return arr;
    }

    /**
     * Exchange the elements at indices i and j in the array arr.
     */
    public static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j]; 
        arr[j] = temp;
    }

    /**
     * Generate a random array of size n where each element is between 0 and n-1.
     */
    public static int[] generateRandomArray(int n, Long seed) {
        // Create a new integer array of size n

        // Shuffle the array using the Shuffle method with the given seed

        // Return the shuffled array
        return new int[n];
    }

    /**
     * Check if the array arr is sorted in ascending order.
     */
    public static boolean isSorted(int[] arr) {
        return true;
    }
}
