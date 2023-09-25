class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Take the first string as the reference
        String prefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            // Compare characters of the current string with the reference string
            int j = 0;
            while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            
            // Update the prefix to the common characters found so far
            prefix = prefix.substring(0, j);
            
            // If the prefix becomes empty, there's no common prefix
            if (prefix.isEmpty()) {
                return "";
            }
        }
        
        return prefix;
    }
}
