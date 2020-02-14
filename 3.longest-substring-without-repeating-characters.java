import java.util.HashMap;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int ans = 0;
        HashMap<Character, Integer> charHashMap = new HashMap<>();
        for (int i=0, j=0; j<len; j++) {
            if (charHashMap.containsKey(s.charAt(j))) {
                i = Math.max(i, charHashMap.get(s.charAt(j)));
            }
            ans = Math.max(ans, j-i+1);
            charHashMap.put(s.charAt(j), j+1);
        }
        return ans;
    }
}
// @lc code=end

