import java.util.*;


public class ArrayAll {
    // 1. Second largest number 
    public static void secondLargest(int arr[]) {
        int l = Integer.MIN_VALUE;
        int sl = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > l) {
                sl = l;
                l = arr[i];
            }

            else if (arr[i] > sl && arr[i] != l) {
                sl = arr[i];
            }
        }
        System.out.println(sl);
    }

    // 2. Remove duplicate(int shorted array)
    public static int removeDuplicate(int arr[]) {
        if (arr.length == 0) {
            return 0;
        }

        int current = 0;

        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[current]) {
                current++;
                arr[current] = arr[j];
            }
        }
        return current + 1;
    }

    // 3 Move Zero(0) at the last
    public static void moveZero(int arr[]) {
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
    }

    //4 Reverse Array
    public static void reverse(int arr[]) {
        int n = arr.length;  // store in n

        for (int i = 0; i < n / 2; i++) {  //total length k adha
            // Swep method
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];  // last element
            arr[n - 1 - i] = temp;
        }
    }

    // 5. Finding missing number in range from 1 to n 
    public static void missingRangeFromOnetoN(int arr[], int N) {
        int originalSum = N * (N + 1) / 2; // 5 *(5+1)/2 = 15
        int actualSum = 0;

        for (int i = 0; i < arr.length; i++) {
            actualSum = actualSum + arr[i];   // 12
        }

        int missingSum = originalSum - actualSum; // 15 - 12 = 3
        System.out.println(missingSum);

    }
    
    // 6. Find element appearing once when others appear twice (XOR)
    public static void findSingle(int arr[]) {
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];      
        }

        System.out.println("Single Appare element = " + result);
    }
    
    // 7 Kadane’s algorithm (maximum subarray sum)
    public static void maxSubArray(int arr[]) {
        int max = arr[0];   // final answer
        int curr = arr[0];    // current subarray ka sum

        for (int i = 1; i < arr.length; i++) {
            curr = Math.max(arr[i], curr + arr[i]); // ya to naya start karo ya purana continue karo
            max = Math.max(max, curr); // max sum update karo
        }

        System.out.println("Maximum sub Arrya = " + max);
    }
    
    // 8. Two Sum (Without using hashMap)
    public static void twoSum(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("i = " + i + " j = "+ j);
                    return;
                }
            }
        }
        System.out.println("Not found");
    }

    // Two Sum (Using HashMap)
    public static int[] twoSumByHashMap(int arr[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // number → index

        for (int i = 0; i < arr.length; i++) {
            int remender = target - arr[i];

            if (map.containsKey(remender)) {
                return new int[]{map.get(remender), i};
            }

            map.put(arr[i], i);
        }

        return new int[]{-1, -1};
    }
    
    // 9. First Occurence(Jo pahli baar number aaega)
    public static void firstOccurence(int arr[], int target) {
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
        System.out.println("Index of first Occurence = " + ans);
    }
    
    // 10. Last Occurence(Jo last me aata hai)
    public static void lastOccurence(int arr[], int target) {
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
        System.out.println("Index of last Occurence = " + ans);
    }
   
    // 11. Search in rotated sorted array
    public static int search(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Left side sorted
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) {
                  high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }

            // right side sorted
            else {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    
    // 12. Find peak Number 
    public static void peakNumber(int arr[]) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        System.out.println("index = " + low + " Value = " + arr[low]);
    } 

    // 13. Merge Two sorted Array
    public static int[] mergeArray(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        int i = 0;  //  for num1
        int j = 0;  //  for num2
        int k = 0;
        
        int result[] = new int[n + m]; 
        
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                k++;
                i++;
            }
            else {
                result[k] = arr2[j];
                k++;
                j++;
            }
        }

        while (i < n) {
            result[k] = arr1[i];
            k++;
            i++;
        }

        while (j < m) {
            result[k] = arr2[j];
            k++;
            j++;
        }

        return result;
    }

    // 14.buy and shell stock
    public static void buySell(int prices[]) {
        int minPrices = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrices;

            maxProfit = Math.max(maxProfit, profit);
            minPrices = Math.min(minPrices, prices[i]);
        }

        System.out.println(maxProfit);
        System.out.println("Index where we have profit = " + prices[maxProfit]);
    }

    // 15. Majority Element
    public static void majorityElement(int arr[]) {
        int curr = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == curr) {
                count++;
            }
            else {
                count--;
                if (count == 0) {
                    curr = arr[i];
                    count = 1;
                }
            }
        }
        
        System.out.println(curr);
    }

    // 16. number of 1 bits(binary me phle convert hoga or check hoga kitna 1 hai binary me)
    public static void countOnes(int num) {
        int count = 0;

        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num = num / 2;
        }
        System.out.println(count);
    }

    // 17. hight altitude
    public static void highAltitude(int arr[]) {
        int altitude = 0;
        int maxAltitude = 0;

        for (int i = 0; i < arr.length; i++) {
            altitude = altitude + arr[i];

            maxAltitude = Math.max(altitude, maxAltitude);
        }
        System.out.println(maxAltitude);
    }

    // 18. Maximum Average Subarray (size = k)
    public static void findMaxAverage(int arr[], int k) {
        int sum = 0;
        int max = 0;

        // First 4 number
        for (int i = 0; i < k; i++) {
            sum = sum + arr[i];
        }

        max = sum;

        // Next sliding number
        for (int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i - k];
            max = Math.max(max, sum);
        }

        double result = (double)max / k;
        System.out.println(result);
    }

    // 19. Find largest number and smallest number 
    public static void maxAndMin(int arr[]) {
        int largest = arr[0];
        int smallest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
            if (arr[i] < smallest) {
                smallest = arr[i];
            }
        }
        System.out.println("Largest Num = "+ largest + " Smallest = " + smallest);
    }

    // 20. Find duplicates in an array
    public static void findDuplicates(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.print(arr[i] + " ");
                    break;
                }
            }
        }
    } 

    // 21 Armstrong Number (153 = 1^3 + 5^3 + 3^3)
    public static void armstrong(int num) {
        int originalNum = num;
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum = sum + (digit * digit * digit);
            num = num / 10;
        }

        if (sum == originalNum) {
            System.out.println("Armstrong Number!");
        }
        else {
            System.out.println("Not Armstrong Number!");
        }
    }

    // 22. Union of 2 array(not sorted or sorted)
    public static void union(int arr1[], int arr2[]) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]); // arr1 ka sara value add ho gya 
        }

        for (int i = 0; i < arr2.length; i++) {   // arr2 ka value but duplicate is not allow
            set.add(arr2[i]);
        }

        System.out.println(set);
    }

    // 23. Intersection of 2 Array(sorted)
    public static void intersection(int arr1[], int arr2[]) {

        // If array is not sorted then used this
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;  // for arr1
        int j = 0; // for arr2

        List <Integer> result = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                result.add(arr1[i]);
                i++;
                j++;
            }
            else if (arr1[i] < arr2[j]) {
                i++;
            }
            else {
                j++;
            }
        }
        System.out.println(result);
    }

    // 24. subArray with Give sum(target wala)
    public static void subArraySum(int arr[], int target) {
        int sum = 0;
        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            
            while (sum > target) {
                sum = sum - arr[start];
                start++;
            }
            if (sum == target) {
                System.out.println("start = " + start + " end = " + i);
                return;
            }
        }
        System.out.println("Not Found!");
    }

    // 25 Leader in Array(Array ka wo element jo apne right side ke sab elements se bada ho
    // Last element hamesha leader hota hai
    public static void leader(int arr[]) {
        int max = arr[arr.length - 1]; // last wala number 
        System.out.print(max + " "); // last number hamesh leader hota hai 

        for (int i = arr.length - 2; i >= 0; i--) {   // last se chalaenge taki number check krne me aasani ho
            if (arr[i] > max) {
                max = arr[i];
                System.out.print(max + " ");
            }
        }
    }

    // 26 Equilibrium index kya hota hai (Wo index i jahan left side ka sum = right side ka sum)
    public static void equilibrium(int arr[]) {
        int totalSum = 0;
        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            totalSum = totalSum + arr[i];
        }
        
        for (int i = 0; i < arr.length; i++) {
            totalSum = totalSum - arr[i];

            if (leftSum == totalSum) {
                System.out.println("Equilibrium index = " + i + " value = " + arr[i]);
                return;
            }

            leftSum = leftSum + arr[i];  // aage number ko add krenge 
        }
        System.out.println("Equilibrium is Not Found");
    }



    public static void main(String[] args) {
        // int arr[] = {10, 20, 4, 45, 99, 16, 93, 100, 96, 100, 10, 20};
        // secondLargest(arr);

        // int arr[] = {10, 20, 20, 30, 30};
        // int removeDuplicate = removeDuplicate(arr);
        // for (int i = 0; i < removeDuplicate; i++) {
        //     System.out.print(arr[i] + " ");
        // }

        // int arr[] = {1, 0, 0, 2, 0, 1};
        // moveZero(arr);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
    
        // int arr[] = {20, 30, 40, 50};
        // reverse(arr);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }

        // int arr[] = {1, 2, 4, 5};
        // int n = 5;
        // missingRangeFromOnetoN(arr, n);
    
        // int arr[] = {2, 3, 5, 4, 5, 3, 2};
        // findSingle(arr);
    
        // int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // maxSubArray(arr);

        // int[] arr = {2, 7, 11, 15};
        // int target = 9;
        // twoSum(arr, target);

        // int [] result = twoSumByHashMap(arr, target);
        // System.out.println(result[0] + " " + result[1]);
    
        // int arr[] = {1, 2, 2, 2, 3, 4};
        // int target = 2;
        // firstOccurence(arr, target);
        // lastOccurence(arr, target);

        // int arr[] = {4, 5, 6, 7, 0, 1, 2};
        // int Target = 0;
        // System.out.println(search(arr, Target));

        // int arr[] = {1, 2, 1, 3, 5, 6, 4};
        // peakNumber(arr);

        // int arr1[] = {1, 4, 6};
        // int arr2[] = {2, 3, 5, 8, 9};
        // int result[] = mergeArray(arr1, arr2);
        // for (int i = 0; i < result.length; i++) {
        //     System.out.print(result[i] + " ");
        // }

        // int prices[] = {7, 1, 5, 3, 6, 4};
        // buySell(prices);

        // int arr[] = {1, 2, 1, 2, 1, 2, 1, 2};
        // majorityElement(arr);

        // countOnes(11);

        // int arr[] = {-5, 1, 5, 0, -7, 10};
        // highAltitude(arr);

        // int nums[] = {1, 12, -5, -6, 50, 3};
        // int k = 4;
        // findMaxAverage(nums, k);
    
        // int arr[] = {1, 12, -5, -6, 50, 3};
        // maxAndMin(arr);

        // armstrong(153);  // Armstrong Number!
        // armstrong(152); //Not Armstrong Number!
    
        // int arr1[] = {1, 2, 4, 5};
        // int arr2[] = {2, 3, 5, 6};
        // union(arr1, arr2); //[1, 2, 3, 4, 5, 6]

        // int arr1[] = {1, 5, 3, 5};
        // int arr2[] = {2, 3, 5};
        // intersection(arr1, arr2); //[2, 5]

        // int arr[] = {1, 4, 20, 3, 10, 5};
        // int target = 33;
        // subArraySum(arr, target); // start = 2 end = 4
    
        // int arr[] = {16, 17, 4, 3, 5, 2};
        // leader(arr); //2 5 17

        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
        equilibrium(arr);  // Equilibrium index = 3(value = 2)
    }
}
