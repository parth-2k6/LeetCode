class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        fun(0, 0, n, res, new StringBuilder());
        return res;
    }
    private void fun(int open, int close, int n, List<String> res, StringBuilder t) 
    {
        // Base Case
        if (open == n && close == n) {
            res.add(t.toString());
            return;
        }
        // Open condition
        if (open < n) {
            t.append('(');
            fun(open + 1, close, n, res, t);
            t.deleteCharAt(t.length() - 1);
        }
        // Close condition
        if (close < open) {
            t.append(')');
            fun(open, close + 1, n, res, t);
            t.deleteCharAt(t.length() - 1);
        }
    }
}