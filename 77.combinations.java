/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    private int n;
    private int k;
    private List<List<Integer>> res;
    private boolean[] vis;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        this.res = new ArrayList<>();
        if (k == 0 || n < k) { return res; }
        this.vis = new boolean[n + 1];
        dfs(1, k);
        return res;
    }

    private void dfs(int index, int rest) {
        if (rest == 0) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < vis.length; i++) {
                if (vis[i]) { tmp.add(i); }
            }
            res.add(tmp);
            return;
        } else if (rest < 0 || index >= vis.length) { return; }
        else {
            vis[index] = true;
            dfs(index + 1, rest - 1);
            vis[index] = false;
            dfs(index + 1, rest);
        }
    }
}
// @lc code=end

