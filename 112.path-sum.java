/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) { return false; }
        int res = sum - root.val;
        if (root.left == null && root.right == null && res == 0) { return true; }
        boolean left = hasPathSum(root.left, res);
        if (left) { return true; }
        boolean right = hasPathSum(root.right, res);
        if (right) { return true; }
        return false;
    }
}
// @lc code=end

