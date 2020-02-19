/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        int ans = -1;
        if (dividend > 0) {
            sign = opposite(sign);
            dividend = opposite(dividend);
        }
        if (divisor > 0) {
            sign = opposite(sign);
            divisor = opposite(divisor);
        }
        if (dividend > divisor) { return 0; }
        int origin_dividend = dividend;
        int origin_divisor = divisor;
        dividend -= divisor;
        while (dividend <= divisor) {
            ans = ans + ans;
            dividend -= divisor;
            divisor += divisor;
        }
        int a = ans + opposite(divide(origin_dividend - divisor, origin_divisor));
        if (a == Integer.MIN_VALUE) {
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            return sign > 0 ? opposite(a) : a;
        }
    }

    public int opposite(int x) {
        return ~x + 1;
    }
}
// @lc code=end

