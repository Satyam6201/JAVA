import java.util.Stack;

public class stacks {
    // Valid paranthesis
    public static void validParentheses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            }
            else {
                if (s.isEmpty()) {
                    System.out.println("Not a Valid Parantheses!");
                    return;
                }
                else if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                }
            }
        }
        if (s.isEmpty()) {
            System.out.println("Valid Paranthese!");
            return;
        }
        else {
            System.out.println("Not a Valid Parantheses!");
        }
    }
    public static void main(String[] args) {
        String str = "({})";
        validParentheses(str);
    }
}