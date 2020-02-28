/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) { return head; }
        int listSize = 1;
        ListNode travel = head;
        while (travel.next != null) {
            listSize++;
            travel = travel.next;
        }
        travel.next = head;
        k %= listSize;
        k = listSize - k;
        travel = head;
        for (int i = 0; i < k; i++) { travel = travel.next; }
        while (head.next != travel) { head = head.next; }
        head.next = null;
        return travel;
    }
}
// @lc code=end

