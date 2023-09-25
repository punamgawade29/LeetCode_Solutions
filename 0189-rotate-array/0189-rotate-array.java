class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n; // To handle cases where k is greater than n
        
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }
         System.arraycopy(result, 0, nums, 0, n);
       
    }
}
