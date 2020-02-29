/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        StringBuilder sb1 = new StringBuilder(a).reverse();
        StringBuilder sb2 = new StringBuilder(b).reverse();
        for (int i = 0; i < sb2.length(); i++) {
            int c2 = sb2.charAt(i) - '0';
            sb1.setCharAt(i, (char) (sb1.charAt(i) + c2));
        }
        for (int i = 0; i < sb1.length() - 1; i++) {
            if (sb1.charAt(i) >= '2') {
                char before = (char) (((sb1.charAt(i) - '0') % 2) + '0');
                sb1.setCharAt(i, before);
                sb1.setCharAt(i + 1, (char) (sb1.charAt(i + 1) + 1));
            }
        }
        if (sb1.charAt(sb1.length() - 1) >= '2') {
            char before = (char) (((sb1.charAt(sb1.length() - 1) - '0') % 2) + '0');
            sb1.setCharAt(sb1.length() - 1, before);
            sb1.append('1');
        }
        return sb1.reverse().toString();
    }
}
// @lc code=end

