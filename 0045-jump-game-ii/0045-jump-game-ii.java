class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0;
        int maxReach = 0; // Initialize the maximum reachable position
        int currentMax = 0; // Initialize the maximum reachable position for the current jump

        for (int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]); // Update maxReach for the current position
            
            if (i == currentMax) {
                jumps++; // Take a jump to the maximum reachable position for the current jump
                currentMax = maxReach; // Update the maximum reachable position for the next jump
            }
        }

        return jumps;
    }
}
