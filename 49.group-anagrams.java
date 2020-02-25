/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> stringGroups = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String normalString = String.valueOf(charArray);
            stringGroups.computeIfAbsent(normalString, k -> new ArrayList<>());
            stringGroups.get(normalString).add(s);
        }
        return new ArrayList<>(stringGroups.values());
    }
}
// @lc code=end

