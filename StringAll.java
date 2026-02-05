public class StringAll{

    // 1. Reverse The String
    public static void reverseString(String s){

        char arr[] = s.toCharArray(); 
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;

            i++;
            j--;
        }

        String reversed = new String(arr);
        System.out.println(reversed);

    }
    public static void main(String[] args) {
        String s = "hello";
        reverseString(s);
    }
}