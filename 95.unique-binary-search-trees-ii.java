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
        if (n == 0) { return new ArrayList<>(); }
        return generateTrees(1, n);
    }
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) { 
            res.add(null);
            return res; 
        }
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        for (int i = start; i <= end; i++) {
            // i as root
            List<TreeNode> leftSubTree = generateTrees(start, i - 1);
            List<TreeNode> rightSubTree = generateTrees(i + 1, end);
            for (TreeNode left : leftSubTree) {
                for (TreeNode right : rightSubTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
// @lc code=end

