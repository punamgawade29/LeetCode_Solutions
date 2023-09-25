class Solution {
    public int lengthOfLastWord(String s) {
        // Trim the input string to remove leading and trailing spaces
        s = s.trim();
        
        int length = 0;
        int i = s.length() - 1;
        
        // Start from the end of the string and count characters until a space is encountered
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        
        return length;
    }
}
