/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            HashMap<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 0;
            int max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {
                    duplicate += 1;
                    continue;
                }
                int up = x2 - x1;
                int down = y2 - y1;
                int commonDivisor = gcd(up, down);
                String key = up/commonDivisor + "_" + down/commonDivisor;
                slopeMap.put(key, slopeMap.getOrDefault(key, 0) + 1);
                max = Math.max(max, slopeMap.get(key));
            }
            res = Math.max(res, duplicate + max + 1);
        }
        return res;
    }
    private int gcd(int a, int b) {
        return b == 0? a : gcd(b, a % b);
    }
}
// @lc code=end

