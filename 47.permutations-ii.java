/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> lst = new ArrayList<>();
        for (int n : nums) { lst.add(n); };
        List<List<Integer>> res = new ArrayList<>();
        while (lst != null) {
            res.add(lst);
            lst = nextPermutation(nums);
        }
        return res;
    }


    private List<Integer> nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i > -1 && nums[i] >= nums[i + 1]) { i--; }
        if (i == -1) { return null; }
        int firstBiggerIndex = firstBiggerIndex(nums, i + 1, nums.length - 1, nums[i]);
        swap(nums, i, firstBiggerIndex);
        reverse(nums, i + 1, nums.length - 1);
        List<Integer> res = new ArrayList<>();
        for (int n : nums) { res.add(n); }
        return res;
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private int firstBiggerIndex(int[] nums, int left, int right, int x) {
        if (left >= right) { return right; }
        int mid = (left + right) / 2;
        int num = nums[mid];
        if (num > x && nums[mid + 1] <= x) { return mid; }
        else if (num > x) { return firstBiggerIndex(nums, mid + 1, right, x); }
        else { return firstBiggerIndex(nums, left, mid - 1, x); }
    }
}
// @lc code=end

