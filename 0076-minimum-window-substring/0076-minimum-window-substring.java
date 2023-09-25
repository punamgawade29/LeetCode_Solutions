import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        
        // Create a frequency map for characters in string t
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        
        // Initialize variables for the sliding window
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        int requiredChars = tMap.size();
        int formedChars = 0;
        Map<Character, Integer> windowMap = new HashMap<>();
        
        // Initialize variables for tracking the window
        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            
            // Check if the current character is in string t and its frequency matches
            if (tMap.containsKey(c) && windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                formedChars++;
            }
            
            // Try to minimize the window size
            while (left <= right && formedChars == requiredChars) {
                // Update the minimum window size
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                
                // Check if we are still maintaining the required characters in the window
                if (tMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
                    formedChars--;
                }
                
                left++;
            }
            
            right++;
        }
        
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        
        return s.substring(minLeft, minLeft + minLen);
    }
}
