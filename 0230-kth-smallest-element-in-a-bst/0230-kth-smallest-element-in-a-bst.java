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
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k; // Initialize the count to k
        inorderTraversal(root);
        return result;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null || count == 0) {
            return;
        }

        inorderTraversal(node.left);

        // If count reaches 0, we have found the kth smallest element
        if (--count == 0) {
            result = node.val;
            return;
        }

        inorderTraversal(node.right);
    }
}
