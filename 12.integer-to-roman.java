import java.util.HashMap;
import java.util.Map;
/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
import java.util.Arrays;
class Solution {
    public String intToRoman(int num) {
        Map<Integer,String> integerToRoman = new HashMap<>();
        integerToRoman.put(1, "I");
        
        integerToRoman.put(4, "IV");
        integerToRoman.put(5, "V");
        integerToRoman.put(9, "IX");
        integerToRoman.put(10, "X");
        integerToRoman.put(40, "XL");
        integerToRoman.put(50, "L");
        integerToRoman.put(90, "XC");
        integerToRoman.put(100, "C");
        integerToRoman.put(400, "CD");
        integerToRoman.put(500, "D");
        integerToRoman.put(900, "CM");
        integerToRoman.put(1000, "M");

        Object[] keys = integerToRoman.keySet().toArray();
        Arrays.sort(keys);
        int[] res = new int[keys.length];
        for (int i = res.length - 1; i > -1; i--) {
            int base = (Integer)keys[i];
            res[i] = num / base;
            num -= res[i] * base;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = res.length - 1; i > -1; i--) {
            while (res[i] > 0) {
                sb.append(integerToRoman.get(keys[i]));
                res[i] -= 1;
            }
        }
        


        return sb.toString();
    }
}
// @lc code=end

