/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s.length() == 1 && s.charAt(0) == '0') { return 0; }
        else if (s.length() == 1) { return 1; }
        int[] dp = new int[s.length()];

        int lastChar = s.charAt(s.length() - 1) - '0';
        if (isValid(lastChar)) { dp[dp.length - 1] = 1; }
        int secondLastChar = s.charAt(s.length() - 2) - '0';
        if (isValid(secondLastChar)) {
            dp[dp.length - 2] += dp[dp.length - 1];
            int sumLast = secondLastChar * 10 + lastChar;
            if (isValid(sumLast)) { dp[dp.length - 2] += 1; }
        }

        for (int i = s.length() - 3; i > -1; i--) {
            int num = s.charAt(i) - '0';
            if (isValid(num)) {
                dp[i] += dp[i + 1];
                int num2 = s.charAt(i + 1) - '0';
                int sum = num * 10 + num2;
                if (isValid(sum)) { dp[i] += dp[i + 2]; }
            }
        }
        return dp[0];
    }
    private boolean isValid(int num) {
        return num > 0 && num < 27;
    }
}
// @lc code=end

