/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0, len2 = 0;
        ListNode curr = l1;
        while (curr != null) {
            len1 += 1;
            curr = curr.next;
        }
        curr = l2;
        while (curr != null) {
            len2 += 1;
            curr = curr.next;
        }
        if (len1 < len2) {
            curr = l1;
            l1 = l2;
            l2 = curr;
        }

        curr = l2;
        ListNode travel = l1;
        while (curr != null) {
            travel.val += curr.val;
            travel = travel.next;
            curr = curr.next;
        }
        travel = l1;

        while (travel.next != null) {
            if (travel.val > 9) {
                travel.next.val++;
                travel.val -= 10;
            }
            travel = travel.next;
        }

        if (travel.val > 9) {
            travel.next = new ListNode(1);
            travel.val -= 10;
        }

        return l1;

    }
}
// @lc code=end

