/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) { return true; }
        if (p == null || q == null) { return false; }
        Queue<TreeNode> treeOne = new LinkedList<>();
        Queue<TreeNode> treeTwo = new LinkedList<>();

        treeOne.offer(p);
        treeTwo.offer(q);
        while (!treeOne.isEmpty()) {
            TreeNode nodeOne = treeOne.poll();
            TreeNode nodeTwo = treeTwo.poll();
            if (nodeOne.val != nodeTwo.val) { return false; }

            TreeNode leftOne = nodeOne.left;
            TreeNode leftTwo = nodeTwo.left;
            if (isTrue((Queue<TreeNode>) treeOne, (Queue<TreeNode>) treeTwo, leftOne, leftTwo)) return false;

            TreeNode rightOne = nodeOne.right;
            TreeNode rightTwo = nodeTwo.right;
            if (isTrue((Queue<TreeNode>) treeOne, (Queue<TreeNode>) treeTwo, rightOne, rightTwo)) return false;
        }
        return true;
    }

    private boolean isTrue(Queue<TreeNode> treeOne, Queue<TreeNode> treeTwo, TreeNode rightOne, TreeNode rightTwo) {
        if (rightOne == null && rightTwo == null) {}
        else if (rightOne == null || rightTwo == null) {
            return true;
        }
        else {
            if (rightOne.val != rightTwo.val) {
                return true;
            }
            treeOne.offer(rightOne);
            treeTwo.offer(rightTwo);
        }
        return false;
    }
}
// @lc code=end

