/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
    private int[] nums;
    private boolean[] vis;
    private int[] tmpRes;
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.res = new ArrayList<>();
        if (nums == null || nums.length == 0) { return res; }
        this.vis = new boolean[nums.length];
        this.tmpRes = new int[nums.length];
        dfs(0);
        return res;
    }

    private void dfs(int level) {
        if (level == nums.length) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int x : tmpRes) { tmp.add(x); }
            res.add(tmp);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!vis[i]) {
                    vis[i] = true;
                    tmpRes[level] = nums[i];
                    dfs(level + 1);
                    vis[i] = false;
                }
            }
        }
    }
}
// @lc code=end

