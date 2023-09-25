class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0; // Initialize the maximum reachable position
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // If the current position is not reachable, return false
            }
            
            maxReach = Math.max(maxReach, i + nums[i]); // Update the maximum reachable position
        }
        
        return true; // If the loop completes, you can reach the last index
    }
}
