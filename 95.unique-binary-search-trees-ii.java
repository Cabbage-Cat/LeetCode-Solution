/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode>[] res = new ArrayList[n + 1];
        res[0] = new ArrayList<>();
        if (n == 0) { return res[n]; }
        res[0].add(null);

        for (int length = 1; length <= n; length++) {
            res[length] = new ArrayList<>();
            for (int root = 1; root <= length; root++) {
                int left = root - 1;
                int right = length - root;
                for (TreeNode leftSubTree : res[left]) {
                    for (TreeNode rightSubTree : res[right]) {
                        TreeNode cloneRoot = new TreeNode(root);
                        cloneRoot.left = leftSubTree;
                        cloneRoot.right = clone(rightSubTree, root);
                        res[length].add(cloneRoot);
                    }
                }
            }
        }
        return res[n];
    }
    private TreeNode clone(TreeNode tree, int offset) {
        if (tree == null) { return tree; }
        TreeNode root = new TreeNode(tree.val + offset);
        root.left = clone(tree.left, offset);
        root.right = clone(tree.right, offset);
        return root;
    }
}
// @lc code=end

