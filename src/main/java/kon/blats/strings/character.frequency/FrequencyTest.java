package kon.blats.strings.character.frequency;

import java.util.Map;

/**
 * Created by kon on 25/8/2018.
 */
public class FrequencyTest {

    public static void main(String[] args) {
        String input = "ak aka";
        CharacterFrequencyCalculator calculator = new CharacterFrequencyCalculator(input);
        Map<Character, Integer> frequencies = calculator.calculateCharacterFrequencies();
        System.out.println();
    }
}
