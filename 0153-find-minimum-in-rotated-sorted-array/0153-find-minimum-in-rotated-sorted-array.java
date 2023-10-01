class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // Check if the mid element is greater than the right element
            if (nums[mid] > nums[right]) {
                left = mid + 1; // Minimum element is on the right
            } else {
                right = mid; // Minimum element is on the left or is the mid element
            }
        }
        
        // Left pointer now points to the minimum element
        return nums[left];
    }
}
