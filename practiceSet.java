import java.util.*;

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
                System.out.println(start + ", " + end);  // show that when sum == k is reach
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
        int original = n; //4884

        int sum = 0;
        while (0 < n) {
            int digit = n % 10; // 4 , 8, 8, 4
            sum = sum * 10 + digit; // 0*10 = 0 + 4 = 4  == 4884
            n = n / 10; 
        }
        if (original == sum) {
            return true;
        }
        return false;
    }

    // Q6. sqrt O(n) // n = 36
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
        System.out.println(ans);  //6
    }
    // Binary search approach
    public static void findSqrt(int n) {  // n = 36
        if (n < 2) {  // if no. is smaller the 2 then return number
            System.out.println(n);
            return;
        }

        int left = 1;
        int right = n / 2;  //18
        int ans = -1;  

        while (left <= right) {
            int mid = (left + right) / 2;   //7

            if (mid * mid <= n) {  
                ans = mid; //6
                left = mid + 1; //7
            }
            else {
                right = mid - 1; // 8 // 6
            }
        }
        System.out.println(ans);
    }

    // 7. Leader in a Array (last element always a leader) //(O(n))
    public static void leader(int arr[]) {  // 16, 17, 4, 3, 5, 2
        ArrayList<Integer> list = new ArrayList<>();

        int n = arr.length - 1;
        int max = arr[n];
        list.add(max);    // 2

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];  // 5  // 17
                list.add(max);  // 5 // 17
            }
        }

        // 2, 5 , 17 
        
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

    // Q8. find the max product subArray O(n)
    public static int maxProduct(int arr[]) {
        int max = arr[0];
        int min = arr[0];
        int maxProduct = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = max;

            int maxFind = Math.max(max * arr[i], min * arr[i]);
            max = Math.max(maxFind, arr[i]); 

            int minFind = Math.min(temp * arr[i], min * arr[i]);
            min = Math.min(arr[i], minFind);

            maxProduct = Math.max(maxProduct, max);
        }

        return maxProduct;
    }
    
    // Q10 Merge Sort O(n)
    public static void merge(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        
        merge(arr, start, mid);
        merge(arr, mid + 1, end);
        mergeSort(arr, start, mid, end);
    }
    public static void mergeSort(int arr[], int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int temp[] = new int[end - start + 1];

        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            }
            else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }
        while (j <= end) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for (k = 0, i = start; k < temp.length; k++, i++) {  // copy of the array
            arr[i] = temp[k];
        }
    }
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    // 11. Isomorphic Strings O(n)
    public static boolean Isomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);

            if (sMap.containsKey(sch)) {
                if (sMap.get(sch) != tch) {
                    return false;
                }
                else {
                    sMap.put(sch, tch);
                }
            }
            if (tMap.containsKey(tch)) {
                if (tMap.get(tch) != sch) {
                    return false;
                }
                else {
                    tMap.put(tch, sch);
                }
            }
        }


        return true;
    }

    // Q.12 search in rotated sorted array 1 - 
    public static void search(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                System.out.println(mid);
                return;
            }
            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
        }
        System.out.println("Not Found!");
    }
    public static void searchs(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("Not Found");
    }

    // 13 count occurrences in a sorted array - O(n) 
    public static int occurrence(int arr[], int target) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;
            }
        }
        return count;
    }


    // Q14 sort 0's, 1's and 2's O(n)
    public static void sortZeros(int arr[]) {
        int n = arr.length;
        int temp[] = new int[n];
        int k = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                temp[k] = arr[i];
                k++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                temp[k] = arr[i];
                k++;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] == 2) {
                temp[k] = arr[i];
                k++;
            }
        }

        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }
    // binery Approach O(logn)
    public static void sortZero(int arr[]) {
        int left = 0;
        int mid = 0;
        int end = arr.length - 1;

        while (mid <= end) {
            if (arr[mid] == 0) {
                int temp = arr[left];
                arr[left] = arr[mid];
                arr[mid] = temp;
                mid++;
                left++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                int temp = arr[end];
                arr[end] = arr[mid];
                arr[mid] = temp;
                end--;
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    
    // Q15. floor and ceil
    public static void floor(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] <= target) {
                ans = arr[mid];
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        System.out.println(ans);
    }
    public static void ceil(int arr[], int target) {
        int low = 0;
        int high = arr.length -1 ;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= target) {
                ans = arr[mid];
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }

    // 16. Find Minimum in Rotated Sorted Array
    public static int findMinimum(int arr[]) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return arr[low];
    }
    public static int minimum(int arr[]) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    } 

    // 17 l
    
    
    public static void main(String[] args) {
        // int arr[] = {3, 2, 3, 4, 5};
        // bubbleSort(arr); // 2 3 3 4 5 

        // int arr[] = {10, 5, 2, 7, 1, 9};
        // int k = 15;
        // longestSubArray(arr, k);  // 4 (1, 4)

        // int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        // sumZero(arr);

        // System.out.println(isPalandrome(4884));  //true

        // sqrt(36);// 6
        // findSqrt(36);  //6

        // int arr[] = {16, 17, 4, 3, 5, 2};
        // // leader(arr);
        // leaders(arr);

        // int arr[] = {2, 3, -2, 4};
        // System.out.println(maxProduct(arr));

        // int arr[] = {6, 3, 9, 5, 2, 8};
        // merge(arr, 0, arr.length - 1);
        // printArray(arr);  // 2 3 5 6 8 9

        // int arr[] = {4, 5, 6, 7, 0, 1, 2};
        // // search(arr, 0);  //4
        // searchs(arr, 0); // 4

        // System.out.println(Isomorphic("egg", "add"));  // true

        // int arr[] = {1, 1 , 2, 2, 2, 2, 3};
        // int terget = 2;
        // System.out.println(occurrence(arr, terget));

        // int arr[] = {2, 2, 0, 0, 1, 0, 0, 2};
        // // sortZeros(arr);  // 0 0 0 0 1 2 2 2
        // sortZero(arr);  // 0 0 0 0 1 2 2 2

        // int arr[] = {3, 4, 4, 7, 8, 10};
        // int target = 5;
        // floor(arr, target);  // 4
        // ceil(arr, target); // 7

        int arr[] = {3,4,5,1,2};
        System.out.println(findMinimum(arr));  // 1
        System.out.println(minimum(arr));  // 1
    }
}