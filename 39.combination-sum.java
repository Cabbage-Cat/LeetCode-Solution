/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    int[] src;
    int[] vis;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        src = candidates;
        vis = new int[candidates.length];
        res = new LinkedList<>();
        dfs(0, target);
        return res;
    }
    private void dfs(int index, int rest) {
        if (rest < 0 || index >= src.length) { return; }
        else if (rest == 0) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < vis.length; i++) {
                if (vis[i] > 0) {
                    for (int j = 0; j < vis[i]; j++) { tmp.add(src[i]); }
                }
            }
            res.add(tmp);
        } else {
            // rest > 0
            vis[index]++;
            dfs(index, rest - src[index]);
            vis[index]--;
            dfs(index + 1, rest);
        }
    }
}
// @lc code=end

