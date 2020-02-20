/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) { return res; }
        int sLen = s.length();
        int wordLen = words[0].length();
        int wordNum = words.length;
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < sLen - wordLen*wordNum + 1; i++) {
            Map<String, Integer> subWordCountMap = new HashMap<>();
            boolean flag = true;
            for (int j = 0; j < wordNum; j++) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                subWordCountMap.put(word, subWordCountMap.getOrDefault(word, 0) + 1);
                if (subWordCountMap.get(word) > wordCountMap.getOrDefault(word, 0)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }
}
// @lc code=end

