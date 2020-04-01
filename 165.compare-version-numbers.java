/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

// @lc code=start
import java.util.*;

class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) { return 0; }
        int[] v1 = new int[250];
        int[] v2 = new int[250];
        StringTokenizer st = new StringTokenizer(version1, ".");
        int index = 0;
        while (st.hasMoreTokens()) {
            int v = Integer.parseInt(st.nextToken());
            v1[index++] = v;
        }
        st = new StringTokenizer(version2, ".");
        index = 0;
        while (st.hasMoreTokens()) {
            int v = Integer.parseInt(st.nextToken());
            v2[index++] = v;
        }
        for (int i = 0; i < 250; i++) {
            if (v1[i] == v2[i]) { continue; }
            else if (v1[i] > v2[i]) { return 1; }
            else { return -1; }
        }
        return 0;
    }
}
// @lc code=end

