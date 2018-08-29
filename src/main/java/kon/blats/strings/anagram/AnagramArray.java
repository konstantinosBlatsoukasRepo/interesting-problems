package kon.blats.strings.anagram;

import java.util.*;

/**
 * Created by kon on 29/8/2018.
 */
public class AnagramArray {
    String[] input;

    public AnagramArray(String[] input) {
        this.input = input;
    }

    public void anagramsBackToBack() {
        Map<String, List<String>> anaMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            char[] word = input[i].toCharArray();
            Arrays.sort(word);
            String sortedWord = String.valueOf(word);
            if (anaMap.containsKey(sortedWord)) {
                anaMap.get(sortedWord).add(input[i]);
            } else {
                List<String> anaList = new ArrayList<>();
                anaList.add(input[i]);
                anaMap.put(sortedWord, anaList);
            }
        }

        Iterator it = anaMap.entrySet().iterator();
        int index = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            List<String> anaList = (List<String>) pair.getValue();
            for (String current : anaList) {
                input[index] = current;
                index++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] input = {"cool", "nik", "looc", "kin"};
        AnagramArray anagramArray = new AnagramArray(input);
        anagramArray.anagramsBackToBack();
    }
}
