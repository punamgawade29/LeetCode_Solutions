class Solution {
    public boolean isPalindrome(String s) {
        // Convert the string to lowercase
        s = s.toLowerCase();

        // Remove non-alphanumeric characters using regular expressions
        s = s.replaceAll("[^a-z0-9]", "");

        // Compare the string with its reverse
        String reversed = new StringBuilder(s).reverse().toString();
        
        return s.equals(reversed);
    }
}
