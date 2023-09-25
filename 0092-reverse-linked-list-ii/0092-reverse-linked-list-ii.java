class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // Move prev to the node just before the left position.
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        // Reverse the sub-list from left to right.
        ListNode current = prev.next;
        ListNode next = null;
        ListNode tail = current; // The tail of the reversed sub-list.
        
        for (int i = left; i <= right; i++) {
            next = current.next;
            current.next = prev.next;
            prev.next = current;
            current = next;
        }
        
        // Connect the tail of the reversed sub-list to the next node.
        tail.next = current;
        
        return dummy.next;
    }
}
