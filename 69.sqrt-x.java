/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0) { return 0; }
        else if (x > 46340 * 46340) { return 46340; }
        int end = 46340;
        return mySqrtHelper(x, 1, end);
    }
    private int mySqrtHelper(int sum, int begin, int end) {
        if (begin >= end) { return begin; }
        int mid = (begin + end) / 2;
        int number = mid * mid;
        if (number == sum || (number < sum && (mid + 1) * (mid + 1) > sum)) { return mid; }
        else if (number < sum) { return mySqrtHelper(sum, mid + 1, end); }
        else { return mySqrtHelper(sum, begin, mid - 1); }
    }

}
// @lc code=end

