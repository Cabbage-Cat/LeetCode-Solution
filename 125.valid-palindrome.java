/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) { return true; }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {

            while (left < right && !isAlphaNumeric(s.charAt(left))) { left++; }
            while (left < right && !isAlphaNumeric(s.charAt(right))) { right--; }
            if (left < right && Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) { return false; }
        }
        return true;
    }
    private boolean isAlphaNumeric(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'A' && c <='Z') || (c >= '0' && c <= '9'));
    }
}
// @lc code=end

