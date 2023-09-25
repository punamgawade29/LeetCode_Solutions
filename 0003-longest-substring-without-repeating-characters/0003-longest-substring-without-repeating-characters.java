import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> uniqueChars = new HashSet<>();
        
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (!uniqueChars.contains(currentChar)) {
                uniqueChars.add(currentChar);
                right++;
                maxLength = Math.max(maxLength, uniqueChars.size());
            } else {
                uniqueChars.remove(s.charAt(left));
                left++;
            }
        }
        
        return maxLength;
    }
}
