/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        
        // If the depths of the left and right subtrees are the same, it's a perfect binary tree.
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1; // Total nodes in a perfect binary tree = 2^depth - 1
        } else {
            // Otherwise, it's not a perfect binary tree. Recursively count nodes in the left and right subtrees.
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    
    private int leftDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }
    
    private int rightDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.right;
        }
        return depth;
    }
}
