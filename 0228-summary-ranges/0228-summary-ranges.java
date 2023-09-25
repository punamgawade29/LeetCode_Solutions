import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int end = start;
            
            // Extend the range until the next number is consecutive
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
                end = nums[i];
            }
            
            if (start == end) {
                result.add(Integer.toString(start));
            } else {
                result.add(start + "->" + end);
            }
        }
        
        return result;
    }
}
