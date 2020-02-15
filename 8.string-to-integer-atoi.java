/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        int i=0;
        int res = 0;
        if (str.equals("")) { return 0; }
        int l = str.length();
        boolean isPositive = true;
        for (; i < l; i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-') { break; }
            else if (c == ' ') { continue; }
            else if (!(c < '0' || c > '9')) { break; }
            else return 0;
        }

        if (i < l && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            if (str.charAt(i) == '-') { isPositive = false; }
            i++;
            if (i < l) {
                char c = str.charAt(i);
                if (c < '0' || c > '9') { return 0; }
            }
        }

        for (; i < l && 
            !(str.charAt(i) < '0' || str.charAt(i) > '9'); i++) {
                if (res > Integer.MAX_VALUE / 10 || res < 0) {
                    if (!isPositive) { return Integer.MIN_VALUE; }
                    return Integer.MAX_VALUE;
                }
                int c = str.charAt(i) - '0';
                res = res*10 + c;
                if (res < 0) {
                    if (!isPositive) { return Integer.MIN_VALUE; }
                    return Integer.MAX_VALUE;
                }
            }
        
        if (!isPositive) { res = -res; }
        return res;

    }
}
// @lc code=end

