public class mathproblem {
    // Q1. Binary to decimal:-
    public static void binDec(int n) {
        int dec = 0;
        int power = 0;

        while (0 < n) {
            int lastDigit = n % 10;
            dec = dec + (lastDigit * (int)Math.pow(2, power));
            power++;
            n = n / 10;
        }
        System.out.println("Decimal Number = " + dec);
    }

    // Q2. Decimal to binary:-
    public static void decBin(int n) {
        int bin = 0;
        int place = 1;

        while (0 < n) {
            int digit = n % 2;
            bin = bin + digit * place;
            place = place * 10;
            n = n / 2;
        }
        System.out.println("Binary Value = " + bin);
    }

    // Q3. GCD(greatest Common Divisior)
    public static void gcd(int n1, int n2) {
        int gcd = 1;

        for (int i = 1; i < Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        if (gcd == 1) {
            System.out.println("GCD = 1");
        }
        else {
            System.out.println("GCD = " + gcd);
        }
    }

    // Q4  Palindrome 
    public static void palindrome(int n) {
        int originalValue = n;
        int reverse = 0;

        while (0 < n) {
            int lastDigit = n % 10;
            reverse = reverse * 10 + lastDigit;
            n = n / 10;
        }

        if (originalValue == reverse) {
            System.out.println(originalValue + " is Palindrome");
        }
        else {
            System.out.println("Not Palindrome ");
        }
    } 
    
    // Q5. Reverse:- 
    public static void reverse(int n) {
        int reverse = 0;

        while (0 < n) {
            int lastDigit = n % 10;
            reverse = reverse * 10 + lastDigit;
            n = n / 10;
        }
        System.out.println("Reverse number is = " + reverse);
    }
    
    // Q6. Armstrong  number
    public static void armstrong(int n) {
        int index = String.valueOf(n).length();
        int sum = 0;
        int originalValue = n;

        while (0 < n) {
            int lastDigit = n % 10;
            int pow = (int)Math.pow(lastDigit, index);
            sum = sum + pow;
            n = n / 10;
        }

        if (sum == originalValue) {
            System.out.println(originalValue +" is Armstrong Number!");
        }
        else {
            System.out.println("Not Armstrong Number!");
        }

    }
    
    // Q7 Print All the divisior:-
    public static void divisior(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }
    
    // Q8 Check a Number is prime or not:-
    public static void primeNumber(int n) {
        if (n <= 1) {
            System.out.println("Not Prime Number");
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println("Not PrimeNumber!");
                return;
            }
        }
        System.out.println("PrimeNumber");
    }
    
    // Q9. LCM:-
    public static void lcm(int n1, int n2) {
        int gcd = 1;

        for (int i = 1; i < Math.min(n1, n1); i++) {
            if (n1 % i == 0 && n1 % i == 0) {
                gcd = i;
            }
        }
        
        int product = n1 * n2;
        int lcm = product / gcd;
        System.out.println(lcm);
    }
    
    // 10 Count Prime Number:-
    public static boolean primeNum(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int countPrimeNum(int n) {
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (primeNum(i)) {
                count++;
            }
        }

        return count;
    }

    // 11 check Prefect Number:-
    public static void isPrefect(int n) {
        int sum = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum = sum + i;
            }
        }
        if (sum == n) {
            System.out.println("This is prefect Number!");
        }
        else {
            System.out.println("Not Prefect Number!");
        }
    }
    
    //  12 Factorial of a given number:
    public static void fact(int n) {
        int factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        } 

        System.out.println(factorial);
    }

    // or  recursion Method:-
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        int fact = n * factorial(n - 1);
        return fact;
    }

    // 13. Largest Number :-
    public static void largest(int n) {
        int largest = 0;

        while (0 < n) {
            int lastDigit = n % 10;
            largest = Math.max(largest, lastDigit);
            n = n / 10;
        }
        System.out.println(largest);
    }

    //  14. Count odd number 
    public static void oddCount(int n) {
        int count = 0;

        while (0 < n) {
            int lastDigit = n % 10;
            if (lastDigit % 2 != 0) {
                count++;
            }
            n = n / 10;
        }

        System.out.println(count);
    }

    // 15. Even count :-
    public static void evenCount(int n) {
        int count = 0;

        while (0 < n) {
            int lastDigit = n % 10;
            if (lastDigit % 2 == 0) {
                count++;
            }

            n = n / 10;
        }
        System.out.println(count);
    }
    
    public static void main(String[] args) {
        // binDec(101);
        // decBin(11);
        // gcd(9, 12);
        // palindrome(12321);
        // reverse(1265);
        // armstrong(153);
        // divisior(36);
        // primeNumber(36);
        // lcm(9, 12);
        // System.out.println(countPrimeNum(6));
        // isPrefect(6);
        // fact(4);
        // System.out.println(factorial(4));
        // largest(529);
        // oddCount(59254);
        evenCount(5874584);

    }
}
