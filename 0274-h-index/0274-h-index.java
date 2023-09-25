import java.util.Arrays;

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations); // Sort the citations array in ascending order
        int n = citations.length;
        int h = 0; // Initialize the h-index
        
        for (int i = n - 1; i >= 0; i--) {
            int papersWithAtLeastCitations = n - i; // Number of papers with at least citations[i] citations
            if (citations[i] >= papersWithAtLeastCitations) {
                h = papersWithAtLeastCitations; // Update the h-index
            } else {
                break; // Stop iterating when the condition is no longer satisfied
            }
        }
        
        return h;
    }
}
