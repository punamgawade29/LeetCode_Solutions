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
    public boolean isSymmetric(TreeNode root) {
        // Base case: If the tree is empty, it is symmetric.
        if (root == null) {
            return true;
        }
        
        // Check if the left and right subtrees are symmetric.
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        // Base case: If both subtrees are empty, they are symmetric.
        if (left == null && right == null) {
            return true;
        }
        
        // If one subtree is empty but the other is not, they are not symmetric.
        if (left == null || right == null) {
            return false;
        }
        
        // Check if the values of the current nodes are equal and
        // if the left subtree of the left tree is symmetric with the
        // right subtree of the right tree, and vice versa.
        return (left.val == right.val) && 
            isSymmetric(left.left, right.right) && 
            isSymmetric(left.right, right.left);
    }
}
