/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode guard = new ListNode(-1);
        guard.next = head;
        ListNode slow = guard;
        ListNode fast = guard;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list2 = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(list2);
        return mergeTwoList(left, right);

    }


    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode guard = new ListNode(-1);
        ListNode curr = guard;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }
        if (list1 != null) { curr.next = list1; }
        else { curr.next = list2; }
        return guard.next;
    }
}
// @lc code=end

