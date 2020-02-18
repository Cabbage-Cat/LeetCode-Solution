/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int l = nums.length;
        for (int i = 0; i < l - 2; i++) {
            for (int j = i + 1; j < l - 2; j++) {
                int firstTwoSum = nums[i] + nums[j];
                int last = target - firstTwoSum;
                int left = j + 1;
                int right = l - 1;
                while (left < right) {
                    int tmp = nums[left] + nums[right];
                    if (tmp == last) {
                        List<Integer> tmpList = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        if (!hasSameList(res, tmpList)) {
                            res.add(tmpList);
                        }
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (tmp < last) { left++; }
                    else { right--; }
                }
//                while (j < l - 2 && nums[j] == nums[j + 1]) j++;
            }
//            while (i < l - 2 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }
    private boolean sameList(List<Integer> listOne, List<Integer> listTwo) {
        Collections.sort(listOne);
        Collections.sort(listTwo);
        int l = listOne.size();
        for (int i = 0; i < l; i++) {
            if (!listOne.get(i).equals(listTwo.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean hasSameList(List<List<Integer>> listSum, List<Integer> list) {
        for (List<Integer> l : listSum) {
            if (sameList(l, list)) { return true; }
        }
        return false;
    }
}
// @lc code=end

