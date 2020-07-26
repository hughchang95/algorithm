package 字符串.括号问题;

import java.util.Stack;

public class 有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.pop() != '(') return false;
            }
            if (c == ']') {
                if (stack.pop() != '[') return false;
            }
            if (c == '}') {
                if (stack.pop() != '{') return false;
            }
        }
        return stack.isEmpty();
    }

}
