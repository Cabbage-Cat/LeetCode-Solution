/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    public void recoverTree(TreeNode root) {
        if (root == null) { return; }
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val >= root.val) {
                if (first == null) {
                    first = prev;
                    second = root;
                } else { second = root; }
            }
            prev = root;
            root = root.right;
        }
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
// @lc code=end

