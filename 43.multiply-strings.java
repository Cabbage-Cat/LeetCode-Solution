/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        StringBuilder sb1 = new StringBuilder(num1);
        sb1 = sb1.reverse();
        char[] number1 = sb1.toString().toCharArray();

        StringBuilder sb2 = new StringBuilder(num2);
        sb2 = sb2.reverse();
        char[] number2 = sb2.toString().toCharArray();


        int[] res = new int[num1.length() + num2.length()];

        for (int j = 0; j < number2.length; j++) {
            for (int i = 0; i < number1.length; i++) {
                int index = i + j;
                int tmp = (number1[i] - '0') * (number2[j] - '0');
                res[index] += tmp;
                if (res[index] > 9) {
                    res[index + 1] += res[index] / 10;
                    res[index] %= 10;
                }
            }
        }

        StringBuilder r = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            r.append(res[i]);
        }
        r = r.reverse();
        int i = 0;
        while (i < r.length() - 1 && r.charAt(i) == '0') { i++; }
        return r.substring(i);
    }
}
// @lc code=end

