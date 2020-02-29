/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 1 && digits[0] != 9) { digits[0]++; return digits; }
        else if (digits.length == 1) {
            return new int[] {1,0};
        } else {
            digits[digits.length - 1] += 1;
            for (int i = digits.length - 1; i > 0; i--) {
                digits[i - 1] += digits[i] / 10;
                digits[i] %= 10;
            }
        }
        if (digits[0] > 9) {
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = res[1] / 10;
            res[1] %= 10;
            return res;
        }
        return digits;
    }
}
// @lc code=end

