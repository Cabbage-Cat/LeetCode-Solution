/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int right = nums.length - 1;
                int left = i + 1;
                while (left < right) {
                    int diff = Math.abs(nums[i] + nums[left] + nums[right] - target);
                    if (diff < minDiff) {
                        minDiff = diff;
                        ans = nums[i] + nums[left] + nums[right];
                    }
                    if (diff == 0) { return ans; }
                    else if (nums[i] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

