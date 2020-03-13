/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    ListNode curr;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        curr = head;
        int size = 0;
        while (head != null) { head = head.next; size++; }
        return inOrder(0, size - 1);
    }

    private TreeNode inOrder(int start, int end) {
        if (start > end) { return null; }
        int mid = (start + end) / 2;
        TreeNode leftSubTree = inOrder(start, mid - 1);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        root.left = leftSubTree;
        root.right = inOrder(mid + 1, end);
        return root;
    }
}
// @lc code=end

