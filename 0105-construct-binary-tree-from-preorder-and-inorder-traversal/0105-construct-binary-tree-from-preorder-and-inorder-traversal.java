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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map to store the indices of elements in the inorder array for quick lookup.
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        // Initialize the root of the tree and the current indices in preorder and inorder arrays.
        int[] preorderIndex = {0};
        return buildTreeHelper(preorder, inorder, inorderMap, preorderIndex, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int[] preorderIndex, int left, int right) {
        // Base case: If left is greater than right, return null (no more nodes to process).
        if (left > right) {
            return null;
        }
        
        // Get the value at the current preorder index and increment the index.
        int rootValue = preorder[preorderIndex[0]++];
        
        // Create the root node.
        TreeNode root = new TreeNode(rootValue);
        
        // Find the index of the root value in the inorder array.
        int inorderIndex = inorderMap.get(rootValue);
        
        // Recursively build the left and right subtrees.
        root.left = buildTreeHelper(preorder, inorder, inorderMap, preorderIndex, left, inorderIndex - 1);
        root.right = buildTreeHelper(preorder, inorder, inorderMap, preorderIndex, inorderIndex + 1, right);
        
        return root;
    }
}
