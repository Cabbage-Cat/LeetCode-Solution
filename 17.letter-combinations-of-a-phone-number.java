/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.equals("") || digits.length() == 0 || digits == null) { return ans; }
        LinkedList<StringBuilder> res = new LinkedList<>();
        String[] numberMap = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno",
                                "pqrs", "tuv", "wxyz" };
        res.add(new StringBuilder());
        for (int i = 0; i < digits.length(); i++) {
            int num = Character.getNumericValue(digits.charAt(i));
            int l = res.size();
            for (int j = 0; j < l; j++) {
                StringBuilder sb = res.removeFirst();
                for (int k = 0; k < numberMap[num].length(); k++) {
                    StringBuilder newsb = new StringBuilder(sb);
                    newsb.append(numberMap[num].charAt(k));
                    res.addLast(newsb);
                }
            }
        }

        for (StringBuilder sb : res) {
            ans.push(sb.toString());
        }
        return ans;
    }
}
// @lc code=end

