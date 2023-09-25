import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        Map<String, Integer> wordCount = new HashMap<>();

        // Populate the word count map with word frequencies
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> currentCount = new HashMap<>();
            int j = i;
            while (j < i + totalLength) {
                String word = s.substring(j, j + wordLength);
                if (!wordCount.containsKey(word)) {
                    break;
                }
                currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                if (currentCount.get(word) > wordCount.getOrDefault(word, 0)) {
                    break;
                }
                j += wordLength;
            }

            if (j == i + totalLength) {
                result.add(i);
            }
        }

        return result;
    }
}
