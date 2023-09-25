class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // If lengths are different, they can't be anagrams
        }
        
        int[] charCount = new int[26]; // Assuming lowercase English letters
        
        // Count characters in string s
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // Decrement character counts based on string t
        for (char c : t.toCharArray()) {
            charCount[c - 'a']--;
        }
        
        // Check if all character counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false; // If any count is non-zero, they are not anagrams
            }
        }
        
        return true;
    }
}
