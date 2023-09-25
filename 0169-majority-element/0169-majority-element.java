class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0]; // Initialize the candidate as the first element
        int count = 1; // Initialize the count of the candidate as 1

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                // If the current element is the same as the candidate, increment the count
                count++;
            } else {
                // If the current element is different from the candidate, decrement the count
                count--;

                // If the count becomes 0, update the candidate to the current element
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        return candidate;
    }
}
