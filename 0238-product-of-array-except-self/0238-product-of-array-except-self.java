class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        // Create arrays to store the products to the left and right of each element
        int[] leftProducts = new int[n];
        int[] rightProducts = new int[n];
        
        // Initialize leftProducts and rightProducts arrays
        leftProducts[0] = 1;
        rightProducts[n - 1] = 1;
        
        // Calculate left products
        for (int i = 1; i < n; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }
        
        // Calculate right products
        for (int i = n - 2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }
        
        // Calculate the final result by multiplying leftProducts and rightProducts
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }
        
        return result;
    }
}
