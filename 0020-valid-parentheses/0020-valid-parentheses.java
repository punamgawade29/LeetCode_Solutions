import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);  // Push opening brackets onto the stack
            } else {
                if (stack.isEmpty()) {
                    return false;  // No matching opening bracket
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;  // Mismatched brackets
                }
            }
        }
        
        return stack.isEmpty();  // If the stack is empty, all brackets have been matched
    }
}
