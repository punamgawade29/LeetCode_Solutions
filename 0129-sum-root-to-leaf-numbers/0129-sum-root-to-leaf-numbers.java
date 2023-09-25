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
    public int sumNumbers(TreeNode root) {
        return sumNumbersDFS(root, 0);
    }
    
    private int sumNumbersDFS(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }
        
        // Update the current number formed by appending the current node's value.
        currentSum = currentSum * 10 + node.val;
        
        // If it's a leaf node, return the current number.
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        // Recursively calculate the sum for left and right subtrees.
        int leftSum = sumNumbersDFS(node.left, currentSum);
        int rightSum = sumNumbersDFS(node.right, currentSum);
        
        // Return the sum of left and right subtrees.
        return leftSum + rightSum;
    }
}

