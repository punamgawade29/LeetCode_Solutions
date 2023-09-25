import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a HashMap to store elements and their indices
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            // If the number is already in the HashMap and the indices satisfy the condition
            if (map.containsKey(num) && Math.abs(i - map.get(num)) <= k) {
                return true;
            }
            
            // Update the index of the current element in the HashMap
            map.put(num, i);
        }
        
        // No such pair found, return false
        return false;
    }
}
