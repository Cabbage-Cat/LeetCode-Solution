/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int patternLength = needle.length();
        int sourceLength = haystack.length();
        if (patternLength > sourceLength) { return -1; }
        int targetHash = getHash(needle);
        int base = 1;
        for (int i = 0; i < patternLength; i++) {
            base *= 31;
        }
        int[] subStringHash = new int[sourceLength - patternLength + 1];
        subStringHash[0] = getHash(haystack.substring(0, patternLength));
        for (int i = 1; i < sourceLength - patternLength + 1; i++) {
            subStringHash[i] = subStringHash[i - 1] * 31 -
                    (haystack.charAt(i - 1) - '0') * base + (haystack.charAt(i - 1 + patternLength) - '0');
        }
        for (int i = 0; i < subStringHash.length; i++) {
            if (targetHash == subStringHash[i]) {
                boolean flag = true;
                for (int k = 0; k < patternLength; k++) {
                    if (needle.charAt(k) != haystack.charAt(i + k)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }

        return -1;
    }

    private int getHash(String s) {
        int l = s.length();
        int res = 0;
        for (int i = 0; i < l; i++){
            res = res * 31 + (s.charAt(i) - '0');
        }
        return res;
    }
}
// @lc code=end

