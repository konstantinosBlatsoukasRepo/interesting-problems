package kon.blats.arrays;

/**
 * Created by k.blatsoukas on 7/18/2018.
 */
public class KadanesAlgorithmTest {

  public static void main(String[] args) {
    KadanesAlgorithm kadanesAlgorithm = new KadanesAlgorithm(10, -10, 10);
    int a[] = kadanesAlgorithm.getA();
    kadanesAlgorithm.printLargestSubarraySum(a);
  }
}
