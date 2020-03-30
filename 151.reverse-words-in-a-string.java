/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
import java.util.*;
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        if (s.equals("")) { return s; }
        StringTokenizer st = new StringTokenizer(s, " ");
        int l = st.countTokens();
        String[] strings = new String[l];
        for (int i = 0; i < l; i++) { strings[i] = st.nextToken(); }
        String res = "";
        for (int i = l - 1; i > 0; i--) { res = res + strings[i] + " "; }
        res += strings[0];
        return res;
    }
}
// @lc code=end

