/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int l = preorder.length;
        return build(preorder,0, l - 1, inorder, 0, l - 1);
    }
    private TreeNode build(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {
        if (preLeft > preRight) { return null; }
        TreeNode root = new TreeNode(pre[preLeft]);
        int i;
        for (i = inLeft; i <= inRight; i++) { if (in[i] == root.val) { break; } }
        int leftSize = i - inLeft;
        int rightSize = inRight - i;
        TreeNode leftSubTree = build(pre, preLeft + 1, preLeft + leftSize, in, inLeft, inLeft + leftSize - 1);
        TreeNode rightSubTree = build(pre, preRight + 1 - rightSize, preRight, in, inRight + 1 - rightSize,inRight);
        root.left = leftSubTree;
        root.right = rightSubTree;
        return root;
    }
}
// @lc code=end

