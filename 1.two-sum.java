/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> intHashMap = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            intHashMap.put(nums[i], i);
        }   
        int[] res = new int[2];
        for (int i=0; i<nums.length; i++) {
            if (intHashMap.containsKey(target - nums[i]) && 
            intHashMap.get(target - nums[i]) != i ){
                res[0] = i;
                res[1] = intHashMap.get(target - nums[i]);
                break;
            }
        }        

        return res;
        
    }
}
// @lc code=end

