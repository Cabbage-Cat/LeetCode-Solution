/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            linkedList.addLast(root.val);
            root = root.right;
        }
        while (linkedList.size() > 1) {
            int first = linkedList.removeFirst();
            int last = linkedList.removeLast();
            if (first != last) { return false; }
        }
        return true;
    }
}
// @lc code=end

