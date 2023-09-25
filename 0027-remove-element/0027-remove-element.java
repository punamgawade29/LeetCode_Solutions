class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0; // Pointer for the left side of the array
        
        // Iterate through the array
        for (int right = 0; right < nums.length; right++) {
            // If the current element is not equal to val, move it to the left side
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        
        // The length of the new array (k) is equal to the left pointer
        return left;
    }
}
