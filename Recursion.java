public class Recursion {
    
    // Q1. Print the number from n to 1
    public static void printNum(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        printNum(n - 1);
    }

    // Q2. print the number from 1 to n
    public static void printNums(int n) {
        if (n == 1) {
            System.out.print(1 + " ");
            return;
        }

        printNums(n - 1);
        System.out.print(n + " ");
    }

    // Q3. Factorial Number of n
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }

        int Factorial = fact(n - 1);
        return n * Factorial;
    }
    // 2 Pointer approact
    public static int Factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact = fact * i; 
        }
        return fact;
    }

    // Q4 Sum of natural Number
    public static int sumOfNatural(int n) {
        if (n == 1) {
            return 1;
        }

        return n + sumOfNatural(n - 1);
    } 

    

    public static void main(String[] args) {
        // Q1.
        // printNum(10);  //10 9 8 7 6 5 4 3 2 1 
        
        // Q2.
        // printNums(10);  // 1 2 3 4 5 6 7 8 9 10 

        // Q3.
        // System.out.println(fact(5));  // 120
        // System.out.println(Factorial(5));  // 120

        // Q4.
        System.out.println(sumOfNatural(5));   // 15

    }
}
