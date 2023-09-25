import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        
        // Sort intervals based on their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            
            // Check for overlap with the current interval
            if (nextInterval[0] <= currentInterval[1]) {
                // Merge the intervals
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // No overlap, add the current interval to the result
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        
        // Add the last remaining interval to the result
        mergedIntervals.add(currentInterval);
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
