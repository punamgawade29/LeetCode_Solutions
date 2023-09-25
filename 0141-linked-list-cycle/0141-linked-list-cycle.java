public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // No cycle if the list is empty or has only one node.
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move one step at a time.
            fast = fast.next.next;  // Move two steps at a time.

            if (slow == fast) {
                return true; // The two pointers meet, indicating a cycle.
            }
        }

        return false; // If fast reaches the end, there is no cycle.
    }
}
