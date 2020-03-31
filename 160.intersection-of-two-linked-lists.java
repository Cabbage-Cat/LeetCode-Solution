/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) { return null; }
        int sizeA = 0, sizeB = 0;
        for (ListNode head = headA; head != null; head = head.next) { sizeA += 1; }
        for (ListNode head = headB; head != null; head = head.next) { sizeB += 1; }
        if (sizeA > sizeB) {
            int tmp = sizeA;
            sizeA = sizeB;
            sizeB = tmp;
            ListNode tmpNode = headA;
            headA = headB;
            headB = tmpNode;
        }
        for (int i = 0; i < sizeB - sizeA; i++) { headB = headB.next; }
        ListNode currA = headA;
        ListNode currB = headB;
        for (int i = 0; i < sizeA; i++) {
            if (currA == currB) { return currA; }
            currA = currA.next;
            currB = currB.next;
        }
        return null;
    }
}
// @lc code=end

