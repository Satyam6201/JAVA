import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class practiceSet {

    // Q1. Bubble Sort  // O(n^2)
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Q2. Longest subArray with sum k   // O(n)
    public static void longestSubArray(int arr[], int k) {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        int n = arr.length;
        int sum = arr[0];

        while (end < n) {
            while (sum > k) {
                sum = sum - arr[start];
                start++;
            }

            if (sum == k) {
                maxLength = Math.max(maxLength, end - start + 1);
                // System.out.println(start + ", " + end);  // show that when sum == k is reach
            }

            end++;
            if (n > end) {
                sum = sum + arr[end];
            } 
        }
        System.out.println(maxLength);
    }
    
    //Q3. largest subarray with the sum 0
    public static void sumZero(int arr[]) {
        int start = 0; 
        int end = 0;
        int maxLength = 0;
        int sum = arr[0];
        int n = arr.length;

        while (end < n) {
            while (sum > 0) {
                sum = sum - arr[start];
                start++;
            }

            if (sum == 0) {
                maxLength = Math.max(maxLength, end - start + 1);
            }

            end++;
            if (end < n) {
                sum = sum + arr[end];
            }
        }
        System.out.println(maxLength);
    }


    // Q5. Check palandrome (O(logn))  // 4884
    public static boolean isPalandrome(int n) {
        int original = n;

        int sum = 0;
        while (0 < n) {
            int digit = n % 10;
            sum = sum * 10 + digit;
            n = n / 10; 
        }
        if (original == sum) {
            return true;
        }
        return false;
    }

    // Q6. sqrt O(n)
    public static void sqrt(int n) {
        int ans = -1;

        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                ans = i;
            }
            else {
                break;
            }
        } 
        System.out.println(ans);
    }
    // Binary search approach
    public static void findSqrt(int n) {
        if (n < 2) {  // if no. is smaller the 2 then return number
            System.out.println(n);
            return;
        }

        int left = 1;
        int right = n / 2;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (mid * mid <= n) {
                ans = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }

    // 7. Leader in a Array (last element always a leader) //(O(n))
    public static void leader(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();

        int n = arr.length - 1;
        int max = arr[n];
        list.add(max);

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                list.add(max);
            }
        }
        
        Collections.reverse(list);
        System.out.println(list);
    }
    // if someone say to find by stack O(n)
    public static void leaders(int arr[]) {
        Stack<Integer> s = new Stack<>();

        int max = arr[arr.length - 1];
        s.push(max);

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
                s.push(max);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }

    }

    public static void main(String[] args) {
        // int arr[] = {3, 2, 3, 4, 5};
        // bubbleSort(arr); // 2 3 3 4 5 

        // int arr[] = {10, 5, 2, 7, 1, 9};
        // int k = 15;
        // longestSubArray(arr, k);  // 4 (1, 4)

        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        sumZero(arr);

        // System.out.println(isPalandrome(4884));  //true

        // sqrt(36);// 6
        // findSqrt(36);  //6

        // int arr[] = {16, 17, 4, 3, 5, 2};
        // // leader(arr);
        // leaders(arr);
    }
}