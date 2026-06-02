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

    // Q5. Fibonacci number
    public static int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int f1 = Fibonacci(n - 1);
        int f2 = Fibonacci(n - 2);
        int fn = f1 + f2;

        return fn;
    }
    
    // Q6. Find the first occurence of element
    public static int firstOcc(int arr[], int index, int key) {
        if (arr.length == index) {
            return -1; // key is not found
        }

        if (arr[index] == key) {
            return index;
        }

        return firstOcc(arr, index + 1, key);
    }

    // Q7. find the last occurence of element 
    public static int lastOcc(int arr[], int index, int key) {
        if (arr.length == index) {
            return -1;
        }

        int find = lastOcc(arr, index + 1, key);

        if (find == - 1 && arr[index] == key) {
            return index;
        }

        return find;
    }

    //Q8. Power of n
    public static int power(int n, int pow) {
        if (pow == 0) {
            return 1;
        }

        int power = n * power(n, pow - 1);
        return power;
    }

    // Q9. Power of n (O(log(n)))
    public static int powers(int n, int pow) {
        if (pow == 0) {
            return 1;
        }

        int halfPower = powers(n, pow / 2);

        int halfSqr = halfPower * halfPower;

        if (pow % 2 != 0) {
            halfSqr = halfSqr * n;
        }
        return halfSqr;
    }

    // Q10. N - Queens Problem 
    public static boolean isSafe(char [][] board, int row, int col) {

        // Vertical Up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Diagonal left up 
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        } 

        return true;
    }
    public static void NQueen(char board[][], int row) {
        if (row == board.length) {
            count++;
            print(board);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                NQueen(board, row + 1);
                board[row][j] = 'X';
            }
        }
    }
    public static void print(char board[][]) {
        System.out.println("--- Chess Board ---");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static int count = 0;

    
    public static void main(String[] args) {
        // Q1.
        // printNum(10);  //10 9 8 7 6 5 4 3 2 1 
        
        // Q2.
        // printNums(10);  // 1 2 3 4 5 6 7 8 9 10 

        // Q3.
        // System.out.println(fact(5));  // 120
        // System.out.println(Factorial(5));  // 120

        // Q4.
        // System.out.println(sumOfNatural(5));   // 15

        // Q5.
        // System.out.println(Fibonacci(6));  // 8  (0, 1, 1, 2, 3, 5, 8)

        // Q6.
        // int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        // System.out.println(firstOcc(arr, 0, 5));  // 4
        // System.out.println(lastOcc(arr, 0, 5));  // 7

        // Q8
        // System.out.println(power(2, 5));  // 32
        // System.out.println(powers(2, 5));  // 32

        // Q10.
        int n = 4;
        char board[][] = new char[n][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 'X';
            }
        }
        NQueen(board, 0);
        System.out.println("Total N Queens are = " + count);

    }
}
