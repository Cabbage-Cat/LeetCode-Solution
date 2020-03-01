/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> line = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        int lineLength = 0;
        for (String word : words) {
            if (lineLength + word.length() > maxWidth) {
                res.add(line);
                line = new ArrayList<>();
                lineLength = 0;
            }
            line.add(word);
            lineLength += word.length() + 1;
        }
        res.add(line);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < res.size() - 1; i++) {
            ans.add(lineToString(res.get(i), maxWidth));
        }
        StringBuilder lastLine = new StringBuilder();
        for (String s : res.get(res.size() - 1)) {
            lastLine.append(s);
            lastLine.append(' ');
        }
        if (lastLine.length() > maxWidth) { ans.add(lastLine.toString().trim()); }
        else {
            while (lastLine.length() < maxWidth) { lastLine.append(' '); }
            ans.add(lastLine.toString());
        }
        return ans;
    }

    private String lineToString(List<String> list, int maxLength) {
        int length = 0;
        for (String word : list) { length += word.length(); }
        if (list.size() == 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(list.get(0));
            while (sb.length() < maxLength) { sb.append(' '); }
            return sb.toString();
        }
        int space = (maxLength - length) / (list.size() - 1);
        int restSpace = (maxLength - length) % (list.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(" ".repeat(Math.max(0, space)));
            if (i < restSpace) { sb.append(' '); }
        }
        while (sb.length() < maxLength) { sb.append(' '); }
        return sb.toString().trim();
    }
}
// @lc code=end

