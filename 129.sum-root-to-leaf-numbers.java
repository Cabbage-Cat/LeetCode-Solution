/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    private int res;
    private List<Integer> list;
    public int sumNumbers(TreeNode root) {
        if (root == null) { return 0; }
        res = 0;
        list = new ArrayList<>();
        helper(root);
        return res;
    }
    private void helper(TreeNode node) {
        if (node.left == null && node.right == null) {
            int tmp = 0;
            for (int x : list) { tmp = tmp * 10 + x; }
            tmp = tmp * 10 + node.val;
            res += tmp;
            return;
        }
        list.add(node.val);
        if (node.left != null) { helper(node.left); }
        if (node.right != null) { helper(node.right); }
        list.remove(list.size() - 1);
    }
}
// @lc code=end

