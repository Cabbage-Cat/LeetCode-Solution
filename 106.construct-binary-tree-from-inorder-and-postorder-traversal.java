/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) { return null; }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode build(int[] in, int inLeft, int inRight, int[] post, int postLeft, int postRight) {
        if (inLeft > inRight || inLeft < 0 || inRight >= in.length) { return null; }
        int root = post[postRight];
        int i;
        for (i = inLeft; i <= inRight; i++) {
            if (in[i] == root) { break; }
        }
        int leftSize = i - inLeft;
        int rightSize = inRight - i;
        TreeNode rootNode = new TreeNode(root);
        TreeNode leftNode = build(in, inLeft, i - 1, post, postLeft, postLeft + leftSize - 1);
        TreeNode rightNode = build(in, i + 1, inRight, post, postRight - rightSize, postRight - 1);
        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;
    }
}
// @lc code=end

