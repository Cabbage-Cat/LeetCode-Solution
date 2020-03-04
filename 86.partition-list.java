/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) { return head; }
        ListNode smallerThanX = new ListNode(-1);
        ListNode smallerGuard = smallerThanX;
        // Set a smaller guard node.
        ListNode greaterThanX = new ListNode(-1);
        ListNode greaterGuard = greaterThanX;
        // Set a greater guard node.

        ListNode curr = head;
        while (curr != null) {
            if (curr.val >= x) {
                greaterThanX.next = curr;
                greaterThanX = greaterThanX.next;
            } else {
                smallerThanX.next = curr;
                smallerThanX = smallerThanX.next;
            }
            curr = curr.next;
        }
        smallerThanX.next = greaterGuard.next;
        greaterThanX.next = null;
        return smallerGuard.next;
    }
}
// @lc code=end

