/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        TreeNode prev = null;

        int nowSum = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                nowSum += root.val;
                root = root.left;
            }
            root = stack.peek();
            if (nowSum == sum && root.left == null && root.right == null) {
                List<Integer> tmp = new ArrayList<>();
                for (TreeNode node : stack) { tmp.add(node.val); }
                res.add(tmp);
            }
            if (root.right == null || root.right == prev) {
                nowSum -= stack.pop().val;
                prev = root;
                root = null;
            } else { root = root.right; }
        }
        return res;
    }
}
// @lc code=end

