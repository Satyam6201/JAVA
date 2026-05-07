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
    public static int maxProduct(int arr[]) {  // 2, 3, -2, 4
        int max = arr[0]; // 2
        int min = arr[0]; // 2
        int maxProduct = arr[0]; // 2

        for (int i = 1; i < arr.length; i++) {  // min = -12, max = 4
            int temp = max;  // -2

            int maxFind = Math.max(max * arr[i], min * arr[i]); // 6 , 6  // -8
            max = Math.max(maxFind, arr[i]);  // 6, 3 // 6  // 4

            int minFind = Math.min(temp * arr[i], min * arr[i]);  // 2 * 3 == 6, -12
            min = Math.min(arr[i], minFind); // 3, 6 // 3 //-12

            maxProduct = Math.max(maxProduct, max); // 6
        }

        return maxProduct;
    }
    
    // Q10 Merge Sort O(n)
    public static void merge(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;  
        
        merge(arr, start, mid);  // 1st
        merge(arr, mid + 1, end); // 2nd
        mergeSort(arr, start, mid, end);
    }
    public static void mergeSort(int arr[], int start, int mid, int end) {   //6, 3, 9, 5, 2, 8
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
    
    // 11. Isomorphic Strings O(n)   egg = add 
    public static boolean Isomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sch = s.charAt(i);  // e  g
            char tch = t.charAt(i); // a dd

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
    public static void search(int arr[], int target) {  // 4, 5, 6, 7, 0, 1, 2  t = 0
        int start = 0; // 4
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2; //  0

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
    public static void sortZero(int arr[]) {  // 2, 2, 0, 0, 1, 0, 0, 2
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
    public static void floor(int arr[], int target) {  // 3, 4, 4, 7, 8, 10  t = 5
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;  // 8

            if (arr[mid] <= target) {
                ans = arr[mid];  // 4
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
                ans = arr[mid];  // 7
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }

    // 16. Find Minimum in Rotated Sorted Array  // 4 5 6 7 0 1 2
    public static int findMinimum(int arr[]) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;  // 0

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            }
            else {
                high = mid;  // 5
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

    // 17 Rearrange array elements by sign - O(n)
    public static void arrangeBySign(int arr[]) {  // 3,1,-2,-5,2,-4   // 3 -2 1 -5 2 -4
        int posIndex = 0;
        int negIndex = 1;

        int temp[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                temp[posIndex] = arr[i];
                posIndex += 2;
            }
            else if (arr[i] < 0) {
                temp[negIndex] = arr[i];
                negIndex += 2;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }
    
    // 18 Subarrays with sum K
    public static void countSubArray(int arr[], int target) { //  9, 4, 20, 3, 10, 5  t = 33
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < n; j++) {
                sum += arr[j];  // 9 + 4 + 20 + 3

                if (sum == target) {
                    count++;  // 2
                }
            }
        }
        System.out.println(count);
    }
    
    // 19. Set Matrix Zeroes 
    public static void setZero(int arr[][]) {   
        //     {1, 1, 1}
        //     {1, 0, 1}  
        //     {1, 1, 1}

        int row = arr.length;
        int col = arr[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (arr[i][j] == 0) {
                    if (i == 0) {
                        firstRowZero = true;
                    }
                    if (j == 0) {
                        firstColZero = true;
                    }
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            Arrays.fill(arr[0], 0);
        }

        if (firstColZero) {
            for (int i = 0; i < row; i++) {
                arr[i][0] = 0;
            }
        }
    }
    public static void printArray(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
    }
    
    // 20 Find First and Last Position of Element in Sorted Array
    // first Position
    public static int firstPos(int arr[], int target) {
        int low = 0; 
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) { 
                ans = mid;
                high = mid - 1;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static int lastPos(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static int[] searchRange(int arr[], int target) {
        int first = firstPos(arr, target);
        int last = lastPos(arr, target);
        return new int[] {first, last};
    }

    // 21 Subsets
    public static List<List<Integer>> subsets(int arr[]) {  // 1, 2, 3
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, arr, new ArrayList<>(), result);
        return result;
    }
    public static void backtrack(int index, int arr[], List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));  // [], [1], [1, 2], [1, 2, 3]

        for (int i = index; i < arr.length; i++) {
            current.add(arr[i]);
            backtrack(i + 1, arr, current, result);
            current.remove(current.size() - 1);
        }
    }
    
    
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
        // search(arr, 0);  //4
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

        // int arr[] = {3,4,5,1,2};
        // System.out.println(findMinimum(arr));  // 1
        // System.out.println(minimum(arr));  // 1


        // int arr[] = {3,1,-2,-5,2,-4};
        // arrangeBySign(arr); // 3 -2 1 -5 2 -4 

        // int arr[] = {9, 4, 20, 3, 10, 5};
        // int target = 33;
        // countSubArray(arr, target);

        // int arr[][] = {
        //     {1, 1, 1},
        //     {1, 0, 1},
        //     {1, 1, 1}
        // };
        // setZero(arr);
        // printArray(arr);

        // int arr[] = {5,7,7,8,8,10};
        // int target = 8;
        // System.out.println(Arrays.toString(searchRange(arr, target)));  // 3, 4


        // int arr[] = {1, 2, 3};
        // System.out.println(subsets(arr)); // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]

    }
}