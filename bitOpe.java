

public class bitOpe {

    // check number is odd or even
    public static void oddEven(int n) {
        int bit = 1;
        if ((n & bit) == 0) {
            System.out.println("Even");
        }
        else {
            System.out.println("Odd");
        }
    }

    //swap two number without using 3 num
    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println("a => " + a + " b => " + b);
    }
    
    // check power of 2 or not
    public static void powerOfTwo(int n) {
        boolean result = ((n & n - 1) == 0);
        if (!result) {
            System.out.println("Not the power of 2");
        }
        else {
            System.out.println("power of 2");
        }
    }
    
    // count set bits of num ( agr != k barabar nhi aaya to count ko badha denge)
    public static void countBit(int n) {
        int count = 0;
        while (0 < n) {
            if ((n & 1) != 0) {
               count++;
            }

            n = n >> 1;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        // oddEven(6); //even
        // swap(5, 7); // 7, 5
        // powerOfTwo(4);  true
        countBit(10);

    }
}
