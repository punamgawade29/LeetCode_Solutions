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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Create a map to store the indices of elements in the inorder array for quick lookup.
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        // Initialize the root of the tree and the current index in the postorder array.
        int[] postorderIndex = {postorder.length - 1};
        return buildTreeHelper(inorder, postorder, inorderMap, postorderIndex, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, Map<Integer, Integer> inorderMap, int[] postorderIndex, int left, int right) {
        // Base case: If left is greater than right, return null (no more nodes to process).
        if (left > right) {
            return null;
        }
        
        // Get the value at the current postorder index and decrement the index.
        int rootValue = postorder[postorderIndex[0]--];
        
        // Create the root node.
        TreeNode root = new TreeNode(rootValue);
        
        // Find the index of the root value in the inorder array.
        int inorderIndex = inorderMap.get(rootValue);
        
        // Recursively build the right and left subtrees (note the order due to postorder traversal).
        root.right = buildTreeHelper(inorder, postorder, inorderMap, postorderIndex, inorderIndex + 1, right);
        root.left = buildTreeHelper(inorder, postorder, inorderMap, postorderIndex, left, inorderIndex - 1);
        
        return root;
    }
}
