class Solution {
    public int maxDepth(TreeNode root) {
        // Base case: if the root is null, the depth is 0.
        if (root == null) {
            return 0;
        }
        
        // Recursive case: calculate the maximum depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // The maximum depth of the current subtree is the maximum of the left and right depths plus 1 for the current node.
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
