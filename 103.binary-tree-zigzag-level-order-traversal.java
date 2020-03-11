/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) { return res; }
        boolean leftFlag = true;
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            ArrayList<TreeNode> temp = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) { temp.add(nodeQueue.removeFirst()); }
            ArrayList<Integer> tempRes = new ArrayList<>();
            for (TreeNode node : temp) { 
                tempRes.add(node.val);
                if (node.left != null) { nodeQueue.add(node.left); }
                if (node.right != null) { nodeQueue.add(node.right); }
            }
            if (!leftFlag) { Collections.reverse(tempRes); }
            res.add(tempRes);
            leftFlag = !leftFlag;
        }
        return res;
    }
}
// @lc code=end

