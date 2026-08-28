class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (st.isEmpty()) {
                st.push(ch);
            } 
            else if (Math.abs(st.peek() - ch) == 32) {
                st.pop();
            } 
            else {
                st.push(ch);
            }
        }

        for (char ch : st) {
            sb.append(ch);
        }

        return sb.toString();
    }
}