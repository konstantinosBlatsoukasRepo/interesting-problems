package kon.blats.largest.sum.contiguous.subarray;

import java.util.SplittableRandom;

/**
 * Created by k.blatsoukas on 7/18/2018.
 */
public class KadanesAlgorithm {

  private final int[] a;

  public KadanesAlgorithm(int arraySize, int from, int to) {
    this.a = new SplittableRandom()
            .ints(arraySize, from, to)
            .parallel()
            .toArray();
  }

  public void printLargestSubarraySum(int[] a) {
    int maxSoFar = Integer.MIN_VALUE;
    int maxEndingHere = 0;

    for (int i = 0; i < a.length; i++) {
      maxEndingHere += a[i];

      if (maxEndingHere < 0) {
        maxEndingHere = 0;
      }

      if (maxSoFar < maxEndingHere) {
        maxSoFar = maxEndingHere;
      }
    }

    System.out.println("The max sum is: " + maxSoFar);
  }

  public int[] getA() {
    return a;
  }
}
