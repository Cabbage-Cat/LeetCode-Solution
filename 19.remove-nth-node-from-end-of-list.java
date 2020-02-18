/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) { return null; }
        ListNode guard = new ListNode(-1);
        guard.next = head;
        ListNode curr = guard;
        while (curr != null) {
            if (isTarget(curr, n)) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return guard.next;
    }

    private boolean isTarget(ListNode node, int n) {
        n = n + 1;
        for (int i = 0; i < n; i++) {
            if (node == null) { return false; }
            node = node.next;
        }
        return node == null;
    }
}
// @lc code=end

