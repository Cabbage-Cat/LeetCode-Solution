/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) { return res; }
        res.add(new ArrayList<>());
        res.get(0).add(root.val);
        
        List<TreeNode> lastLevel = new ArrayList<>();
        lastLevel.add(root);
        
        while (!lastLevel.isEmpty()) {
            List<TreeNode> thisLevelNode = new ArrayList<>();
            List<Integer> thisLevelValue = new ArrayList<>();
            for (TreeNode node : lastLevel) {
                if (node.left != null) {
                    thisLevelNode.add(node.left); 
                    thisLevelValue.add(node.left.val);
                }
                if (node.right != null) {
                    thisLevelNode.add(node.right);
                    thisLevelValue.add(node.right.val);
                }
            }
            lastLevel = thisLevelNode;
            if (!thisLevelValue.isEmpty()) { res.add(thisLevelValue); }
        }
        return res;
    }
}
// @lc code=end

