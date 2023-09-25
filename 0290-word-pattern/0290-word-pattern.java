class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) {
            return false;
        }
        
        Map<Character, String> patternToWord = new HashMap<>();
        Map<String, Character> wordToPattern = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            String word = words[i];
            
            if (!patternToWord.containsKey(pChar) && !wordToPattern.containsKey(word)) {
                patternToWord.put(pChar, word);
                wordToPattern.put(word, pChar);
            } else if (!patternToWord.containsKey(pChar) || !wordToPattern.containsKey(word)
                    || !patternToWord.get(pChar).equals(word) || wordToPattern.get(word) != pChar) {
                return false;
            }
        }
        
        return true;
    }
}
