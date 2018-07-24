package kon.blats.sorting.insertion;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by kon on 21/7/2018.
 */
public class InsertionSort {

    public static int[] sort(int[] table) {
        Objects.requireNonNull(table);

        for (int i = 0; i < table.length; i++) {
            for (int j = i; j > 0 && table[j - 1] > table[j]; j--) {
                swap(j, j - 1, table);
            }
        }

        return table;
    }

    public static void swap(int i, int j, int [] table) {
        int temp = table[i];
        table[i] = table[j];
        table[j] = temp;
    }

    public static void main(String[] args) {
        int[] testTable = new int[]{3, 2, 1, 45, 34, 5};
        sort(testTable);
        System.out.println(Arrays.toString(testTable));
    }
}
