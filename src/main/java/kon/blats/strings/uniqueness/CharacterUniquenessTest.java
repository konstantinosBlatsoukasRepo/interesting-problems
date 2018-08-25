package kon.blats.strings.uniqueness;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kon on 12/8/2018.
 */
public class CharacterUniquenessTest {

    public static void main(String[] args) {
        String uniqueString = "abcd";
        System.out.println(isUnique(uniqueString));

        String nonUniqueString = "abcda";
        System.out.println(isUnique(nonUniqueString));
    }

    private static boolean isUnique(String input) {
        char[] characters = input.toCharArray();
        Set<Integer> setOfCharacters = new HashSet<>();
        for (int i = 0; i < characters.length; i++) {
            char character = characters[i];
            setOfCharacters.add((int) character);
        }
        return characters.length == setOfCharacters.size();
    }

}
