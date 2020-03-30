/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (String x : tokens) {
            if (isOperator(x)) {
                char op = x.charAt(0);
                Integer second = numbers.pop();
                Integer first = numbers.pop();
                Integer third = 0;
                if (op == '+') { third = first + second; }
                else if (op == '-') { third = first - second; }
                else if (op == '*') { third = first * second; }
                else if (op == '/') { third = first / second; }
                numbers.push(third);
            }
            else { numbers.push(Integer.parseInt(x)); }
        }
        return numbers.pop();
    }
    private boolean isOperator(String expr) {
        return expr.equals("+") || expr.equals("-") || expr.equals("*") || expr.equals("/");
    }

}
// @lc code=end

