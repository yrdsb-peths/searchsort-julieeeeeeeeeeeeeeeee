package searchsort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MergeSortTest {
    private final Long seed = 12345L;
    private final Sort mergeSort = new MergeSort();

    @Test
    public void testMergeSort() {

        // Test case 1: Unsorted array
        int[] input = { 5, 2, 9, 1, 5, 6 };
        int[] expected = { 1, 2, 5, 5, 6, 9 };

        mergeSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSort_AlreadySorted() {
        // Test case 2: Already sorted array
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 1, 2, 3, 4, 5 };

        mergeSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSort_Empty() {
        // Test case 3: Empty array
        int[] input = {};
        int[] expected = {};

        mergeSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSort_SingleElement() {
        // Test case 4: Single-element array
        int[] input = { 3 };
        int[] expected = { 3 };

        mergeSort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testMergeSort_LargeArray() {
        // Test case 5: Large array
        int[] input = Util.generateRandomArray(200000, seed);
        mergeSort.sort(input);
        assertTrue(Util.isSorted(input));
    }
}
