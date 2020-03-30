/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode guard = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head;
        ListNode before = guard;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            while (before.next != null && before.next.val < curr.val) { before = before.next; }
            curr.next = before.next;
            before.next = curr;
            before = guard;
            curr = next;
        }
        return guard.next;
    }
}
// @lc code=end

