
import java.util.HashMap;

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
    
    // 2. Find duplicates in an array
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
    
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubArray(arr);

        // int[] arr = {2, 7, 11, 15};
        // int target = 9;
        // twoSum(arr, target);

        // int [] result = twoSumByHashMap(arr, target);
        // System.out.println(result[0] + " " + result[1]);
    }
}
