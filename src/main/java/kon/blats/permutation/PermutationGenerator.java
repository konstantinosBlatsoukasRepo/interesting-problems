package kon.blats.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by k.blatsoukas on 8/20/2018.
 */
public class PermutationGenerator {

  public static void main(String[] args) {
    String permutationTest = "abcd";
    char[] permutationTestChars = permutationTest.toCharArray();
    generatePermutations(permutationTestChars);
  }

  public static List<String> generatePermutations(char[] permutationTestChars) {
    List<String> permutations = new ArrayList<>();
    for (int currentChar = permutationTestChars.length - 1; currentChar >= 0; currentChar--) {
      permutations = generatePermutations(permutations, permutationTestChars[currentChar]);
    }
    return permutations;
  }

  public static List<String> generatePermutations(List<String> permutations, char newCharacter) {
    List<String> freshPermuations = new ArrayList<>();
    if (permutations.isEmpty()) {
      freshPermuations.add(String.valueOf(newCharacter));
      return freshPermuations;
    }

    for (String permutation : permutations) {
      freshPermuations.addAll(generatePermutationsFor(permutation, newCharacter));
    }

    return freshPermuations;
  }

  public static List<String> generatePermutationsFor(String oldPermutation, char newCharacter) {
    List<String> freshPermutations = new ArrayList<>();
    String initialPermutation = initializeFreshPermutation(oldPermutation, newCharacter);
    freshPermutations.add(initialPermutation);

    char[] initialPermutationChars = initialPermutation.toCharArray();
    for (int i = 0; i < initialPermutation.length() - 1; i++) {
      swap(initialPermutationChars, i, i + 1);
      freshPermutations.add(new String(initialPermutationChars));
    }
    return freshPermutations;
  }

  public static String initializeFreshPermutation(String oldPermutation, char newCharacter) {
    char[] freshPermutation = new char[oldPermutation.toCharArray().length + 1];
    char[] oldPermutationChars = oldPermutation.toCharArray();
    freshPermutation[0] = newCharacter;
    for (int i = 1; i < freshPermutation.length; i++) {
      freshPermutation[i] = oldPermutationChars[i - 1];
    }
    return new String(freshPermutation);
  }

  public static void swap(char[] permutation, int i, int j) {
    char temp = permutation[i];
    permutation[i] = permutation[j];
    permutation[j] = temp;
  }

}
