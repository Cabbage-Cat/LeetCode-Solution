/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            factorial *= i;
        }
        StringBuilder res = new StringBuilder();
        k--;
        for (int i = n; i > 0; i--) {
            factorial /= nums.size();
            int groupNumber = k / factorial;
            res.append(nums.get(groupNumber));
            k %= factorial;
            nums.remove(groupNumber);
        }
        return res.toString();
    }
}
// @lc code=end

