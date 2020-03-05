/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
    private boolean[] vis;
    private int[] nums;
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        this.vis = new boolean[nums.length];
        res = new ArrayList<>();
        dfs(0);
        return res;
    }
    private void dfs(int x) {
        if (x == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < vis.length; i++) {
                if (vis[i]) { tmp.add(nums[i]); }
            }
            if (!listIsExist(res, tmp)) { res.add(tmp); }
        } else {
            vis[x] = true;
            dfs(x + 1);
            vis[x] = false;
            dfs(x + 1);
        }

    }


    private boolean listIsExist(List<List<Integer>> res, List<Integer> list) {
        for (List<Integer> l : res) {
            if (listIsSame(l, list)) { return true; }
        }
        return false;
    }
    private boolean listIsSame(List<Integer> l1, List<Integer> l2) {
        if (l1 == null || l2 == null || l1.size() != l2.size()) { return false; }
        if (l1 == l2) { return true; }
        Collections.sort(l1);
        Collections.sort(l2);
        int l = l1.size();
        for (int i = 0; i < l; i++) {
            int x = l1.get(i);
            int y = l2.get(i);
            if (x != y) { return false; }
        }
        return true;
    }
}
// @lc code=end

