import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the elements and their indices
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // Check if the complement exists in the hashmap
            if (map.containsKey(complement)) {
                // If found, return the indices of the two numbers
                return new int[] {map.get(complement), i};
            }
            // Otherwise, add the current number and its index to the hashmap
            map.put(nums[i], i);
        }
        
        // If no solution is found, return an empty array
        return new int[0];
    }
}
