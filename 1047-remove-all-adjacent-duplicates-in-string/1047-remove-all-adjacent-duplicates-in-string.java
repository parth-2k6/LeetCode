import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int i; int n = s.length();
        for (i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (st.isEmpty()) {
                st.push(c);
                continue;
            }
            if (st.peek() == c) { 
                st.pop();
                continue;
            }
            st.push(c);
        }
        StringBuilder res = new StringBuilder();    
        while (!st.isEmpty()) {
            res.append(st.peek()); 
            st.pop();
        }
          return res.reverse().toString(); 
    }
}