/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) { return; }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstList = head;
        ListNode secondList = slow.next;
        slow.next = null;
        secondList = reverseList(secondList);
        ListNode curr = firstList;
        while (firstList != null && secondList != null) {
            curr = firstList;
            firstList = firstList.next;
            curr.next = secondList;
            secondList = secondList.next;
            curr.next.next = firstList;
        }
    }
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode first = head;
        ListNode second = head.next;
        first.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = first;
            first = second;
            second = tmp;
        }
        return first;
    }
}
// @lc code=end

