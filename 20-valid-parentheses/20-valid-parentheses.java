class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isOpenBracket(ch)) {
                stack.push(ch);
            } else if (isCloseBracket(ch)) {
                if (stack.size() < 1) return false;
                
                char openBracket = stack.pop();
                char expectedOpenBracket = getOppositeBracket(ch);
                if (openBracket != expectedOpenBracket) {
                    return false;
                }
            }
        }
        
        return stack.empty();
    }
    
    private boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }
    
    private boolean isCloseBracket(char ch) {
        return ch == ')' || ch == '}' || ch == ']';
    }
    
    private char getOppositeBracket(char closingBracket) {
        if (closingBracket == ')') {
            return '(';
        } else if (closingBracket == '}') {
            return '{';
        }
        return '[';
    }
}
