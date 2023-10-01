import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // Stores the left half of numbers
    private PriorityQueue<Integer> minHeap; // Stores the right half of numbers

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a); // Max-heap for the left half
        minHeap = new PriorityQueue<>(); // Min-heap for the right half
    }

    public void addNum(int num) {
        // Add the number to the appropriate heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        // Balance the heaps if necessary
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // If the sizes of both heaps are equal, return the average of the top elements
            return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // Otherwise, the max-heap will always have the median element
            return (double) maxHeap.peek();
        }
    }
}


/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */