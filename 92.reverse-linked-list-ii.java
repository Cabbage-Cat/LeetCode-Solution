/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) { return head; }
        ListNode guard = new ListNode(-1);
        guard.next = head;
        ListNode before = guard, last;
        for (int i = 1; i < m; i++) { before = before.next; }

        int l = n - m;
        ListNode prev = before.next;
        ListNode curr = prev.next;
        while (l-- > 0) {
            ListNode tmp = curr;
            curr = curr.next;
            tmp.next = prev;
            prev = tmp;
        }
        before.next.next = curr;
        before.next = prev;
        return guard.next;
    }
}
// @lc code=end

