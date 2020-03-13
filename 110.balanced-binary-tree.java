/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getValidDepth(root) != -1;
    }
    
    private int getValidDepth(TreeNode node) {
        if (node == null) { return 0; }
        int leftSize = getValidDepth(node.left);
        if (leftSize == -1) { return -1; }
        
        int rightSize = getValidDepth(node.right);
        if (rightSize == -1) { return -1; }
        
        if (Math.abs(leftSize - rightSize) > 1) { return -1; }
        return Math.max(leftSize, rightSize) + 1;
    }
}
// @lc code=end

