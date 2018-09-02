package kon.blats.arrays;

import java.util.Arrays;
import java.util.Objects;
import java.util.SplittableRandom;

/**
 * Created by k.blatsoukas on 7/27/2018.
 */
public class ArrayReversal {

  public static void reverse(int[] arr) {
    Objects.requireNonNull(arr);
    int start = 0;
    int end = arr.length - 1;

    while (start < end) {
      swap(arr, start, end);
      start++;
      end--;
    }
  }

  public static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] arr = new SplittableRandom()
            .ints(10, -6, 59)
            .parallel()
            .toArray();

    System.out.println("Before the reversal");
    Arrays.toString(arr);

    reverse(arr);

    System.out.println("After the reversal");
    Arrays.toString(arr);
  }

}
