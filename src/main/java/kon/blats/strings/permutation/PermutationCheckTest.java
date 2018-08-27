package kon.blats.strings.permutation;

import java.util.Arrays;

/**
 * Created by kon on 12/8/2018.
 */
public class PermutationCheckTest {
    public static void main(String[] args) {
        char[] firstString = "bca".toCharArray();
        char[] secondString = "bac".toCharArray();

        Arrays.sort(firstString);
        Arrays.sort(secondString);

        System.out.println(firstString);
        System.out.println(secondString);

        System.out.println(isPermutation(firstString, secondString));
    }

    private static boolean isPermutation(char[] a, char[] b) {
        if(a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}
