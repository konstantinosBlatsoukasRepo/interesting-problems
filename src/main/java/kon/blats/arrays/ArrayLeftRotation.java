package kon.blats.arrays;

import java.util.Arrays;
import java.util.Objects;
import java.util.SplittableRandom;

/**
 * Created by k.blatsoukas on 7/27/2018.
 */
public class ArrayLeftRotation {

  public static int[] rotate(int[] arr, int timesToRotate) {
    int[] firstPartOfTheArray = Arrays.copyOfRange(arr, 0, timesToRotate);
    reverse(firstPartOfTheArray);

    int[] secondPartOfTheArray = Arrays.copyOfRange(arr, timesToRotate, arr.length);
    reverse(secondPartOfTheArray);

    int[] both = Arrays.copyOf(firstPartOfTheArray, firstPartOfTheArray.length + secondPartOfTheArray.length);
    System.arraycopy(secondPartOfTheArray, 0, both, firstPartOfTheArray.length, secondPartOfTheArray.length);

    reverse(both);
    return both;
  }

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
            .ints(5, -6, 59)
            .parallel()
            .toArray();

    rotate(arr, 2);
  }
}
