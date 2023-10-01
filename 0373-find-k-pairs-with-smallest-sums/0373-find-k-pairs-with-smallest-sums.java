import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Create a min-heap based on the sum of pairs
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] + a[1] - (b[0] + b[1]));

        // Initialize the heap with pairs from the first element of nums1 and all elements of nums2
        for (int i = 0; i < nums2.length; i++) {
            minHeap.offer(new int[] { nums1[0], nums2[i], 0 }); // [value1, value2, index1]
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int value1 = pair[0];
            int value2 = pair[1];
            int index1 = pair[2];

            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(value1);
            currentPair.add(value2);
            result.add(currentPair);

            if (index1 < nums1.length - 1) {
                // Add the next pair from nums1 with the same value2
                minHeap.offer(new int[] { nums1[index1 + 1], value2, index1 + 1 });
            }

            k--;
        }

        return result;
    }
}
