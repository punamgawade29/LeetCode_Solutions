class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0; // Pointer for string s
        int tPointer = 0; // Pointer for string t

        while (sPointer < s.length() && tPointer < t.length()) {
            // If the current characters match, move both pointers
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            tPointer++;
        }

        // If all characters in s are matched (sPointer reaches s.length()), it's a subsequence.
        return sPointer == s.length();
    }
}
