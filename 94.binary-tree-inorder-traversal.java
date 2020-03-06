/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !nodeStack.isEmpty()) {
            while (curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            }
            curr = nodeStack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
// @lc code=end

