import java.util.*;

public class interview {

    // Find smallest and largest element
    public static int[] smallestAndLargest(int arr[]) {
        int smallest = arr[0];
        int largest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return new int[]{smallest, largest};
    }

    // Reverse the array
    public static void reverse(int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n/2; i++) {
            // Swap 
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // rotate array by k steps 
    public static void rotateKStep(int arr[], int k) {
        int n = arr.length;
        int temp[] = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = arr[i];  // move element to new position
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i]; //arrange original array
        }

        System.out.println(Arrays.toString(arr));
    }

    // zero in the last(end)
    public static void moveZero(int arr[]) {
        int n = arr.length;
        int temp[] = new int[n];

        int index = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[index] = arr[i];
                index++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }

        System.out.println(Arrays.toString(arr));
    }

    // find Second largest Number in Array
    public static void secondLargest(int arr[]) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }

            else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        System.out.println(secondLargest);
    }

    // Remove Duplicate in array
    public static void removeDuplicate(int arr[]) {
        Arrays.sort(arr);
        int current = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[current]) {
                current++;
                arr[current] = arr[i];
            }
        }
        for (int i = 0; i <= current; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Misiing number from 1 to N
    public static void missingNumber(int arr[], int N) {
        int expectedSum = N * (N + 1) / 2;
        int actualSum = 0;

        for (int i = 0; i < arr.length; i++) {
            actualSum = actualSum + arr[i];
        }

        int missingNum = expectedSum - actualSum;

        System.out.println(missingNum);
    }
    
    // Add two number 
    public static void addTwoNum(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Target is found = " + arr[i] + "," + arr[j]);
                    return;
                }
            }
        }
        System.out.println("target is not found!");
    }

    // maximum subArray 
    public static void maxSubArray(int arr[]) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            
            if (currentSum < 0) {
                currentSum = 0;
            }

        }
        System.out.println("maxSum = " + maxSum);
    }    

    // CountDistinct  in array
    public static void CountDistinct(int arr[]) {
        HashSet<Integer> map = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            map.add(arr[i]);
        }

        System.out.println(map);
    }

    // Majority Element
    public static void majorityElement(int arr[]) {
        int candidate = arr[0];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate) {
                count++;
            }
            else {
                count--;
            }
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            }
        }
        System.out.println(count);
    }

    // Appear only once 
    public static void singleElemet(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println(arr[i]);
                break;
            }
        }
    }

    // Reverse the string
    public static void reverseString(char arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            // Swep
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        System.out.println(Arrays.toString(arr));
    }

    // palindrome or not 
    public static void palindrome(String word) {
        int n = word.length();

        boolean isPalindrome = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(n - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome == true) {
            System.out.println("Word is palindrome");
        }
        else {
            System.out.println("Word is not palindrome!");
        }
    }

    // Count vowels and consonants
    public static void countVowelsAndConsonants(String word) {
        word = word.toLowerCase();
        int vowel = 0;
        int consonants = 0;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowel++;
                }
                else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowel = " + vowel);
        System.err.println("Consonants = " + consonants);
    }

    // Anagram 
    public static void anagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            System.out.println("This is not anagram");
            return;
        }

        int [] letter = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            letter[word1.charAt(i) - 'a']++;
            letter[word2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letter[i] != 0) {
                System.out.println("This is not anagram");
                return;
            }
        }
        System.out.println("This is anagram");
    }

    // UpperCase and LowerCase
    public static void UpperCaseAndLowerCase(String word) {
        char[] arr = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            // Change word in the Uppercase
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char)(arr[i] - 32);
            }
            // Change word in the lowerCase
            else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] = (char)(arr[i] + 32);
            }
        }
        System.out.println(new String(arr));
    }

    // FrequencyCount by using Array
    public static void FrequencyCount(int arr[]) {
        int freq[] = new int[10]; //range 0-9

        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;  //Each time a number appears, increase its count.
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println(i + "->" + freq[i]);
            }
        }
    }

    // find first duplicate number
    public static void firstDuplicate(int arr[]) {

        // 1st Method(O(n)2)

        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = i + 1; j < arr.length; j++) {
        //         if (arr[i] == arr[j]) {
        //             System.out.println(arr[i]);
        //             return;
        //         }
        //     }
        // }

        // 2nd method 
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i+1]) {
                System.out.println(arr[i]);
            }
        }
    }

    // Check the array is equal or not 
    public static void CheckArrayEqual(int arr1[], int arr2[]) {
        if (arr1.length != arr2.length) {
            System.out.println("Array is not equal");
            return;
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println("Array is Not equal");
                return;
            }
        }
        System.out.println("Array is equal");
    }

    // Intersection in  the array
    public static void Intersection(int num1[], int num2[]) {
        Arrays.sort(num1);
        Arrays.sort(num2);

        int i = 0;
        int j = 0;

        int lastPrintNumber = Integer.MIN_VALUE;  // to avoid duplicate number 

        while(i < num1.length && j < num2.length) {
            if (num1[i] == num2[j]) {
                if (num1[i] != lastPrintNumber) {
                    System.out.print(num1[i] + " ");
                    lastPrintNumber = num1[i];
                }
                i++;
                j++;
            }
            else if (num1[i] < num2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
    }

    // prime number or not 
    public static void primeNumber(int num) {
        if (num <= 1) {
            System.out.println("Not a Prime Number!");
        }
        else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    System.out.println("Not a Prime Number!");
                    return;
                }
                
            }
        }
        System.out.println(num + " is prime number");
    }

    // Armstrong number 
    public static void Armstrong(int num) {
        
        // For 3 digit number 

        // int original = num;
        // int sum = 0;

        // while (num > 0) {
        //     int digit = num % 10;
        //     sum = sum + (digit * digit * digit);
        //     num = num / 10;
        // }
        // if (sum == original) {
        //     System.out.println("Amastrong number");
        // }
        // else {
        //     System.out.println("Not Amastrong number");
        // }

        // for 4 digit num 

        int original = num;
        int sum = 0;
        int digits = 0;
        int temp = num;

        // Step 1: count digits
        while (temp > 0) {
           digits++;
           temp /= 10;
        }

        temp = num;

        // Step 2: power sum
        while (temp > 0) {
           int digit = temp % 10;
           sum += Math.pow(digit, digits);
           temp /= 10;
        }

        if (sum == original)
            System.out.println("Armstrong number");
        else
            System.out.println("Not Armstrong number");
    }

    // LCM and GCD
    public static void lcmAndGcd(int a, int b) {
        int temp_a = a;
        int temp_b = b;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int gcd = a;

        
        int lcm = (temp_a * temp_b) / gcd;
        
        System.out.println("GCD = " + gcd);
        System.out.println("LCM = " + lcm);
    }

    // nth tribonacci number
    public static void tribonacci(int num) {
        if (num == 0) {
            System.out.println(0);
            return;
        }

        if (num == 1 || num == 2) {
            System.out.println(1);
            return;
        }
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int tn = 0;

        for (int i = 3; i <= num; i++) {
            tn = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = tn;
        }
        System.out.println(tn);
    }

    // number of 1 bit 
    public static void oneBit(int num) {
        int count = 0;

        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            } 
            num /= 2;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        // int arr[] = {12, 5, 9, 25, 3, 18};
        // int result[] = smallestAndLargest(arr);
        // System.out.println("smallest no. = " + result[0]);
        // System.out.println("largest no. = " + result[1]);

        // reverse(arr);

        // rotateKStep(arr, 2);

        // int num[] = {0, 0, 1, 1, 2, 0, 4, 5};
        // moveZero(num);

        // secondLargest(arr);

        // int num[] = {0, 0, 1, 1, 2, 0, 4, 5};
        // removeDuplicate(num);

        // int num[] = {1, 2, 4, 5};
        // missingNumber(num, 5);

        // addTwoNum(arr, 28);

        // int num[] = {-1, 2, -4, 5};
        // maxSubArray(num);

        // int num[] = {1, 2, 1, 2, 4, 5};
        // CountDistinct(num);

        // int num[] = {1, 2, 1, 1, 2, 2, 2, 1, 2};
        // majorityElement(num);

        // int num[] = {1, 2, 1, 2, 1, 2, 3};
        // singleElemet(num);

        // char string[] = {'a', 'w', 't', 'y'};
        // reverseString(string);

        // String word = "markram";
        // palindrome(word);

        // String word = "markram";
        // countVowelsAndConsonants(word);

        // anagram("satyam", "atysas");

        // UpperCaseAndLowerCase("SatyAm");

        // int num[] = {1, 2, 1, 2, 1, 2, 3};
        // FrequencyCount(num);

        // int num[] = {1, 2, 2, 1, 2, 3, 3};
        // firstDuplicate(num);

        // int arr1[] = {1, 2, 2, 1, 2, 3, 3};
        // int arr2[] = {3, 3, 2, 1, 2, 1, 2};

        // CheckArrayEqual(arr1, arr2);

        // Intersection(arr1, arr2);

        // primeNumber(7);

        // Armstrong(9474);

        // lcmAndGcd(12, 18);

        // tribonacci(10);
        
        oneBit(11);
    }
}