package kon.blats.sorting.quicksort;

/**
 * Created by kon on 25/7/2018.
 */
public class QuickSort {

    public static void sort(int[] arr, int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) { return; }

        int pivot = sortAndGetPivot(arr, lowerBound, upperBound);

        sort(arr, lowerBound, pivot - 1);
        sort(arr, pivot + 1, upperBound);
    }

    public static void swap(int i, int j, int [] table) {
        int temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }

    public static int sortAndGetPivot(int[] arr, int lowerBound, int upperBound) {
        int pivot = arr[upperBound];

        int i = lowerBound - 1;
        for (int currentElement = lowerBound; currentElement < upperBound; currentElement++) {
            if (arr[currentElement] <= pivot) {
                i++;
                swap(i, currentElement, arr);
            }
        }

        swap(i + 1, upperBound, arr);
        return i + 1;
    }

    public static void main(String[] args) {
        int[] testTable = new int[]{10, 80, 30, 90, 40, 50, 70};
        sort(testTable, 0, testTable.length - 1);
    }
}
