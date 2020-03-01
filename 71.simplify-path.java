/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(path, "/");

        List<String> pathElements = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            String elem = stringTokenizer.nextToken();
            if (!elem.equals(".")) { pathElements.add(elem); }
        }
        Stack<String> pathHelperStack = new Stack<>();
        for (String s : pathElements) {
            if (!s.equals("..")) { pathHelperStack.push(s); }
            else if (!pathHelperStack.isEmpty()) { pathHelperStack.pop(); }
        }
        StringBuilder res = new StringBuilder();
        while (!pathHelperStack.isEmpty()) {
            res.insert(0,"/" + pathHelperStack.pop());
        }
        return res.toString().equals("") ? "/" : res.toString();
    }
}
// @lc code=end

