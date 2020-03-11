/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) { return true; }
        Queue<TreeNode> left = new ArrayDeque<>();
        Queue<TreeNode> right = new ArrayDeque<>();
        if (root.left == null && root.right == null) {}
        else if (root.left == null || root.right == null) { return false; }
        else {
            left.offer(root.left);
            right.offer(root.right);
        }
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode currLeft = left.poll();
            TreeNode currRight = right.poll();
            // case 1
            if (currLeft.val != currRight.val) { return false; }

            // case 2
            if (currLeft.right == null && currRight.left == null) {}
            else if (currLeft.right != null && currRight.left != null) {
                left.offer(currLeft.right);
                right.offer(currRight.left);
            } else { return false; }

            // case 3
            if (currLeft.left == null && currRight.right == null) {}
            else if (currLeft.left != null && currRight.right != null) {
                left.offer(currLeft.left);
                right.offer(currRight.right);
            } else { return false; }
        }
        return true;
    }
}
// @lc code=end

