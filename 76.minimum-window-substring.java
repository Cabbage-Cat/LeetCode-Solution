/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) { return ""; }
        HashMap<Character, Integer> patternFrequencyHashMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            int freq = patternFrequencyHashMap.getOrDefault(c, 0);
            patternFrequencyHashMap.put(c, freq + 1);
        }

        int[] ans = {Integer.MAX_VALUE, 0, 0};
        // ans[0] minimum window length.
        // ans[1] left res
        // ans[2] right res

        int required = patternFrequencyHashMap.size();
        int left = 0, right = 0;
        int formed = 0;
        HashMap<Character, Integer> slidingWindow = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            int count = slidingWindow.getOrDefault(c, 0);
            slidingWindow.put(c, count + 1);
            if (patternFrequencyHashMap.containsKey(c) &&
                patternFrequencyHashMap.get(c).intValue() == slidingWindow.get(c).intValue()) { formed++; }

            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] > right - left + 1) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                slidingWindow.put(c, slidingWindow.get(c) - 1);
                if (patternFrequencyHashMap.containsKey(c) &&
                        slidingWindow.get(c) < patternFrequencyHashMap.get(c)) {
                    formed--;
                }
                left++;
            }

            right++;
        }
        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);

    }
}
// @lc code=end

