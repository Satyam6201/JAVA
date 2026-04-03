import java.util.Stack;

public class stacks {

    // Valid paranthesis
    public static boolean validParentheses(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            }
            else {
                if (s.isEmpty()) {
                    return false;
                }
                else if ((s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        }
        return false;
    }
    
    // Reverse string using stack
    public static void reverseString(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        System.out.println(sb);
    }
    
    // Next greater element
    public static void nextGreater(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int temp[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // jab tak stack ka top current element se chhota ya equal hai
            // tab tak usko hata do (kyunki wo next greater nahi ho sakta)
           while (!s.isEmpty() && s.peek() <= arr[i]) {
            s.pop();
           }

            // agar stack empty ho gaya  koi bada element nahi mila
           if (s.isEmpty()) {
            temp[i] = -1;
           }
           // warna stack ka top hi next greater element hai
           else {
            temp[i] = s.peek();
           }

            // ab current element ko stack me daal do
            // taaki future elements ke liye use ho sake
            s.push(arr[i]);
        }

        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }
    
    // Previous smallest element
    
    
    
    public static void main(String[] args) {
        // String str = "({})";
        // System.out.println(validParentheses(str));

        // String str = "hello";
        // reverseString(str);

        int arr[] = {6, 8, 0, 1, 3};
        nextGreater(arr);
    }
}