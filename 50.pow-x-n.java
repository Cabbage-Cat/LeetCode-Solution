/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if (Double.compare(x, 0) == 0) { return 0; }
        else if (Double.compare(x, 1) == 0) { return 1; }
        else if (Double.compare(x, -1) == 0) { return n%2 == 1? -1 : 1; }
        else if (n == Integer.MIN_VALUE) { return 0; }
        double res = pow(x, Math.abs(n));
        if (n < 0) { res = 1 / res; }
        return res;
    }
    private double pow(double x, int n) {
        if (n == 0) { return 1; }
        double tmp = pow(x, n/2);
        double res = tmp * tmp;
        if (n % 2 == 1) { res *= x; }
        return res;
    }
}
// @lc code=end

