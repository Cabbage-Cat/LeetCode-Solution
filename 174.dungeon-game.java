/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;
        int[] dp = new int[c + 1];
        for (int i = 0; i < c + 1; i++) { dp[i] = Integer.MAX_VALUE; }
        dp[c - 1] = dungeon[r - 1][c - 1] > 0 ? 1 : -dungeon[r - 1][c - 1] + 1;
        for (int i = r - 1; i > -1; i--) {
            for (int j = c - 1; j > -1; j--) {
                if (i == r - 1 && j == c - 1) { continue; }

                dp[j] = Math.min(dp[j], dp[j + 1]) - dungeon[i][j];
                if (dp[j] <= 0) { dp[j] = 1; }
            }
        }
        return dp[0];
    }

}
// @lc code=end

