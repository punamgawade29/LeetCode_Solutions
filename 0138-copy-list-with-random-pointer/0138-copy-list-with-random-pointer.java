import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node current = head;

        // First pass: create a copy of each node and map the original node to its copy.
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;

        // Second pass: connect the copied nodes using next and random pointers.
        while (current != null) {
            Node copyNode = map.get(current);
            copyNode.next = map.get(current.next);
            copyNode.random = map.get(current.random);
            current = current.next;
        }

        // Return the head of the copied list.
        return map.get(head);
    }
}
