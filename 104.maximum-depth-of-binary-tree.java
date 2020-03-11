/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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
    int maxDepth;
    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        dfs(root, 1);
        return maxDepth;
    }
    private void dfs(TreeNode node, int depth) {
        if (node == null) { return; }
        if (depth > maxDepth) { maxDepth = depth; }
        if (node.left != null) { dfs(node.left, depth + 1); }
        if (node.right != null) { dfs(node.right, depth + 1); }
    }
}
// @lc code=end

