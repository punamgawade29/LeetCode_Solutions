import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);

        // Create a min-heap based on capital requirements
        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(new int[] { capital[i], profits[i] });
        }

        for (int i = 0; i < k; i++) {
            // Add available projects to the max-heap based on capital
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }

            // If there are available projects with positive profits, select the most profitable one
            if (!maxProfitHeap.isEmpty()) {
                w += maxProfitHeap.poll();
            } else {
                break; // No available projects can be started
            }
        }

        return w;
    }
}
