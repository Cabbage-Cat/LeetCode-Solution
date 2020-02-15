/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) { return false; }
        return isPalindromeHelper(x);
    }

    private boolean isPalindromeHelper(int x) {
        if (x == 0) { return true; }
        int helper = 0;
        int tmp = x;
        while (tmp > 0) {
            helper = helper * 10 + tmp % 10;
            tmp /= 10;
        }
        return x == helper;
    }
}
// @lc code=end

