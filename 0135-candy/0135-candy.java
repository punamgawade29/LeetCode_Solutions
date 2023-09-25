class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Initialize each child with one candy
        Arrays.fill(candies, 1);
        
        // Traverse from left to right, ensuring that right neighbors have more candies if ratings increase
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Traverse from right to left, ensuring that left neighbors have more candies if ratings increase
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        // Calculate the total number of candies needed
        int totalCandies = 0;
        for (int i = 0; i < n; i++) {
            totalCandies += candies[i];
        }
        
        return totalCandies;
    }
}
