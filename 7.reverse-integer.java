import java.util.LinkedList;

/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int res = 0;
        boolean isPositive = true;
        if (x < 0) { 
            isPositive = false; 
            x = -x;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        while (x > 0) {
            queue.add(x%10);
            x /= 10;
        }
        while (!queue.isEmpty()) {
            if (res > Integer.MAX_VALUE / 10) { return 0; }
            res = res * 10 + queue.remove();

        }
        return isPositive?res:-res;
    }
}
// @lc code=end

