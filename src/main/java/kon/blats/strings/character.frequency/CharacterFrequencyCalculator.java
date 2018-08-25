package kon.blats.strings.character.frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kon on 25/8/2018.
 */
public class CharacterFrequencyCalculator {
    private String input;
    private Map<Character, Integer> frequencyMap;

    public CharacterFrequencyCalculator(String input) {
        this.input = input;
        frequencyMap = new HashMap<>();
    }

    public Map<Character, Integer> calculateCharacterFrequencies() {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            int frequency = 1;
            if (frequencyMap.containsKey(Character.valueOf(aChar))) {
                int currentFrequency = frequencyMap.get(Character.valueOf(aChar));
                currentFrequency++;
                frequency = currentFrequency;
            }
            frequencyMap.put(Character.valueOf(aChar), frequency);
        }
        return frequencyMap;
    }
}
