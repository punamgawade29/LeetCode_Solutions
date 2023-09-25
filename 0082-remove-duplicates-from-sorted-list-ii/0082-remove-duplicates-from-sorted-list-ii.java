class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0); // Dummy node to handle the case where the first node is a duplicate.
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = head;
        
        while (current != null) {
            boolean isDuplicate = false;
            
            // Check if the current node has duplicates.
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
                isDuplicate = true;
            }
            
            if (isDuplicate) {
                prev.next = current.next; // Skip the duplicates.
            } else {
                prev = prev.next;
            }
            
            current = current.next;
        }
        
        return dummy.next;
    }
}

