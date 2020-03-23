/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    List<List<String>> res;
    List<String> tmp;
    String s;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        tmp = new ArrayList<>();
        this.s = s;
        helper(0);
        return res;
    }
    private void helper(int index) {
        if (index == s.length()) {
            List<String> lst = new ArrayList<>(tmp);
            res.add(lst);
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String s1 = s.substring(index, i);
            if (isValid(s1)) {
                tmp.add(s1);
                helper(i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    private boolean isValid(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) { return false; }
        }
        return true;
    }
}
// @lc code=end

