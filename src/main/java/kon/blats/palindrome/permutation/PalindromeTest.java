package kon.blats.palindrome.permutation;

/**
 * Created by kon on 12/8/2018.
 */
public class PalindromeTest {

    public static void main(String[] args) {
        char[] testSting = "tac tcak".toCharArray();
        int[] frequencyArray = buildFrequencyArray(testSting);
        System.out.println(isAnyPermutationPalindrome(frequencyArray));
    }

    private static int[] buildFrequencyArray(char[] testSting) {
        int[] frequencyArray = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (int i = 0; i < testSting.length; i++) {
            if (!Character.isWhitespace(testSting[i])) {
                int frequencyAtIndex = Character.getNumericValue(testSting[i]) - Character.getNumericValue('a');
                frequencyArray[frequencyAtIndex]++;
            }
        }
        return frequencyArray;
    }

    private static boolean isAnyPermutationPalindrome(int[] frequencyArray) {
        int oddFrequenciesCounter = 0;
        for (int i = 0; i < frequencyArray.length; i++) {
            int characterFrequency = frequencyArray[i];
            if (characterFrequency != 0 && !isEvenNumber(characterFrequency)) {
                oddFrequenciesCounter++;
                if (oddFrequenciesCounter > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

}
