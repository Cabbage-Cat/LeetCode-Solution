/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode guard = new ListNode(-1);
        guard.next = head;
        ListNode prev = guard;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val != curr.next.val) {
                prev = curr;
                curr = curr.next;
            } else {
                while (curr.next != null && curr.val == curr.next.val) { curr = curr.next; }
                curr = curr.next;
                prev.next = curr;
            }
        }
        return guard.next;
    }
}
// @lc code=end

