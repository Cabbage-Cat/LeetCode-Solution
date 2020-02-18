/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>(n);
        dp.add(new ArrayList<>());
        dp.get(0).add("");

        for (int i = 1; i <= n ;i++) {
            List<String> curr = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1s = dp.get(j);
                List<String> str2s = dp.get(i - 1 - j);
                for (String s1 : str1s) {
                    for (String s2 : str2s) {
                        curr.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(curr);
        }
        return dp.get(n);
    }
}
// @lc code=end

