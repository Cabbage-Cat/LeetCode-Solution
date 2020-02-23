/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    int[] src;
    int[] vis;
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        src = candidates;
        vis = new int[src.length];
        dfs(0, target);
        return res;
    }
    private void dfs(int index, int rest) {
        if (rest == 0) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < vis.length; i++) {
                if (vis[i] > 0) {
                    for (int j = 0; j < vis[i]; j++) { tmp.add(src[i]); }
                }
            }
            if (!isDuplicate(res, tmp)) { res.add(tmp); }
        } else if (rest < 0 || index >= src.length) {
            return;
        } else {
            vis[index]++;
            dfs(index + 1, rest - src[index]);
            vis[index]--;
            dfs(index + 1, rest);
        }
    }

    private boolean isDuplicate(List<List<Integer>> res, List<Integer> lst) {
        for (List<Integer> l : res) {
            if (isSameList(l, lst)) { return true; }
        }
        return false;
    }

    private boolean isSameList(List<Integer> list1, List<Integer> list2) {
        Collections.sort(list1);
        Collections.sort(list2);
        if (list1.size() != list2.size()) { return false; }
        int l = list1.size();
        for (int i = 0; i < l; i++) {
            if (!list1.get(i).equals(list2.get(i))) { return false; }
        }
        return true;
    }
}
// @lc code=end

