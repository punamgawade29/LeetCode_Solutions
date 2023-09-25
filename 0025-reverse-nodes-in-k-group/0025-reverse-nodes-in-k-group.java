class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Check if there are at least k nodes remaining in the list.
        ListNode current = head;
        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        
        if (count < k) {
            return head; // Not enough nodes to reverse, return the current head.
        }
        
        // Reverse the first k nodes and call the function recursively.
        ListNode prev = null;
        current = head;
        for (int i = 0; i < k; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        // Recursively reverse the remaining part of the list.
        head.next = reverseKGroup(current, k);
        
        return prev; // New head of the reversed sub-list.
    }
}
