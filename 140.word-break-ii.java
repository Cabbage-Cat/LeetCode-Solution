/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
    private HashSet<String> dict;
    private HashMap<String, List<String>> resultMap;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.dict = new HashSet<>(wordDict);
        this.resultMap = new HashMap<>();
        return helper(s);
    }
    private List<String> helper(String s) {
        if (s == null || s.equals("")) { return new ArrayList<>(); }
        if (resultMap.containsKey(s)) { return resultMap.get(s); }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (dict.contains(s.substring(i))) {
                if (i == 0) { res.add(s); }
                else {
                    List<String> first = helper(s.substring(0, i));
                    for (String x : first) {
                        res.add(x + " " + s.substring(i));
                    }
                }
            }
        }
        resultMap.put(s, res);
        return res;
    }
}
// @lc code=end

