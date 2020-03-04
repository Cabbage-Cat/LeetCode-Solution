/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
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
        ListNode prev = head;
        ListNode curr = prev.next;

        while (curr != null) {
            while (curr != null && curr.val == prev.val) { curr = curr.next; }
            prev.next = curr;
            prev = curr;
        }
        return head;
    }
}
// @lc code=end

