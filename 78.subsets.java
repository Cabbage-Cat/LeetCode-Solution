/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    private boolean[] vis;
    private int[] nums;
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        this.vis = new boolean[nums.length];
        this.nums = nums;
        this.res = new ArrayList<>();
        if (nums == null || nums.length == 0) { return res; }
        dfs(0);
        return res;
    }
    private void dfs(int index) {
        if (index >= nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (vis[i]) { tmp.add(nums[i]); }
            }
            res.add(tmp);
            return;
        }
        else {
            vis[index] = true;
            dfs(index + 1);
            vis[index] = false;
            dfs(index + 1);
        }
    }
}
// @lc code=end

