/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        Arrays.fill(candys, 1);
        for (int i = 1; i < candys.length; i++) {
            int candy = candys[i];
            if (ratings[i] > ratings[i - 1] && candy <= candys[i - 1]) { candy = candys[i - 1] + 1; }
            candys[i] = candy;
        }
        for (int i = candys.length - 2; i > -1; i--) {
            int candy = candys[i];
            if (i < candys.length - 1) {
                if (ratings[i] > ratings[i + 1] && candy <= candys[i + 1]) { candy = candys[i + 1] + 1; }
            }
            candys[i] = candy;
        }
        int res = 0;
        for (int candy : candys) { res += candy; }
        return res;
    }

}
// @lc code=end

