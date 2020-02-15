/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        int groupSize = 2*numRows - 2;
        if (s.equals("") || numRows < 2) { return s; }
        StringBuilder stringBuilder = new StringBuilder();

        for (int j=0; j<numRows; j++) {
            int first = j;
            int second = groupSize - j;
            while (first < s.length()) {
                stringBuilder.append(s.charAt(first));
                first += groupSize;

                if (j>0 && j<numRows - 1) {
                    if (second < s.length()) {
                        stringBuilder.append(s.charAt(second));
                        second += groupSize;
                    }
                }
            }
        }

        return stringBuilder.toString();
    }
}
// @lc code=end

