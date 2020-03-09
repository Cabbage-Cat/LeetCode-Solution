/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    private HashMap<TreeNode, Integer> leftMaxValue;
    private HashMap<TreeNode, Integer> rightMinValue;
    public boolean isValidBST(TreeNode root) {
        leftMaxValue = new HashMap<>();
        rightMinValue = new HashMap<>();
        return helper(root);
    }
    private boolean helper(TreeNode root) {
        if (root == null) { return true; }
        if (root.left == null && root.right == null) { return true; }
        int leftMaxValue = getMaxValue(root.left);
        if (root.right == null) { return root.val > leftMaxValue && helper(root.left); }
        int rightMinValue = getMinValue(root.right);
        if (root.left == null) { return root.val < rightMinValue && helper(root.right); }
        boolean firstMatch = root.val > leftMaxValue && root.val < rightMinValue;
        return firstMatch && helper(root.left) && helper(root.right);
    }
    private int getMaxValue(TreeNode root) {
        if (root == null) { return Integer.MIN_VALUE; }
        if (leftMaxValue.containsKey(root)) { return leftMaxValue.get(root); }
        Queue<TreeNode> list = new LinkedList<>();
        while (root.right != null) {
            list.add(root);
            root = root.right;
        }
        list.add(root);
        int val = root.val;
        for (TreeNode node : list) { leftMaxValue.put(node, val); }
        return val;
    }
    private int getMinValue(TreeNode root) {
        if (root == null) { return Integer.MAX_VALUE; }
        if (rightMinValue.containsKey(root)) { return rightMinValue.get(root); }
        Queue<TreeNode> list = new LinkedList<>();
        while (root.left != null) {
            list.add(root);
            root = root.left;
        }
        list.add(root);
        int val = root.val;
        for (TreeNode node : list) { rightMinValue.put(node, val); }
        return val;
    }
}
// @lc code=end

