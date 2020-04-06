/*
 * @lc app=leetcode id=166 lang=java
 *
 * [166] Fraction to Recurring Decimal
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long deno = denominator;
        String sign = "";
        if (num * deno < 0) { sign = "-"; }
        num = Math.abs(num);
        deno = Math.abs(deno);
        long integer = num / deno;
        num -= integer * deno;
        HashMap<Long, Integer> map = new HashMap<>();
        int index = 0;
        StringBuilder decimal = new StringBuilder();
        int repeatIndex = -1;

        while (num != 0) {
            num *= 10;
            if (map.containsKey(num)) {
                repeatIndex = map.get(num);
                break;
            }
            map.put(num, index);
            long incr = num / deno;
            decimal.append(incr);
            num = num - deno * incr;
            index++;
        }
        if (repeatIndex != -1) {
            return sign + integer + '.' +decimal.substring(0, repeatIndex) + '(' + decimal.substring(repeatIndex) + ')';
        } else {
            if (index == 0) {
                return sign + integer;
            } else {
                return sign + integer + '.' + decimal.toString();
            }
        }
    }
}
// @lc code=end

