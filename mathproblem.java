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
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println("Not PrimeNumber!");
                return;
            }
        }
        System.out.println("PrimeNumber");
    }
    public static void main(String[] args) {
        // binDec(101);
        // decBin(11);
        // gcd(9, 12);
        // palindrome(12321);
        // reverse(1265);
        // armstrong(153);
        // divisior(36);
        primeNumber(36);

    }
}
