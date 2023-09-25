class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26]; // Assuming lowercase English letters
        
        // Count the frequency of each character in magazine
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        // Check if we can construct ransomNote
        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] > 0) {
                charCount[c - 'a']--;
            } else {
                return false; // Not enough characters in magazine
            }
        }
        
        return true;
    }
}
