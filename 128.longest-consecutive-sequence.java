/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) { set.add(x); }
        int res = 0;
        for (int x : nums) {
            if (!set.contains(x - 1)) {
                int cnt = 0;
                while (set.contains(x)) {
                    cnt++;
                    x++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
// @lc code=end

