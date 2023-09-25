class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int uniqueCount = 1; // Count of unique elements, initialize with 1 as the first element is always unique
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous element, it's a unique element
            if (nums[i] != nums[i - 1]) {
                nums[uniqueCount] = nums[i]; // Move the unique element to the next position
                uniqueCount++; // Increment the count of unique elements
            }
        }
        
        return uniqueCount;
    }
}
