import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class greedyAlgorithm {
    
    // Q1. Assign Cookies
    public static int findContentChildren(int g[], int s[]) {

        // step1 sort all the array
        Arrays.sort(g);  // child
        Arrays.sort(s);  // Cookies
        
        int child = 0;
        int cookies = 0;

        while (child < g.length && cookies < s.length) {
            if (s[cookies] >= g[child]) {
                child++;
            }
            cookies++;
        }
        return child;
    }
    
    // Q2. Fractional Knapsack Problem
    public static int knapsackProblem(int value[], int weight[], int w) {
        double ratio[][] = new double[value.length][2];
        // 0th place = index, 1th place = ratio

        // step 1 
        for (int i = 0; i < value.length; i++) {
            ratio[i][0] = 1;  // stored index
            ratio[i][1] = value[i] / weight[i];
        }

        Arrays.sort(ratio, Comparator.comparing(o -> o[1]));

        int capacity = w; 
        int finalValue = 0;
        
        for (int i = ratio.length - 1; i >= 0; i--) {
            int index = (int)ratio[i][0];
            if (capacity >= weight[index]) {
                finalValue = finalValue + value[index];
                capacity = capacity - weight[index]; 
            }
            else {
                finalValue += (int)(ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        return finalValue;
    }
    
    // Q3.  Lemonade Change
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }
            else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            }
            else {   // bills = 20
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                }
                else if (five >= 3) {
                    five -= 3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
    
    // Q4.  Jump Game - 1 
    public static boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, nums[i] + i);
        }
        return true;
    }
    
    // Q5. Jump Game II (Return the minimum number of jumps to reach index n - 1)
    public static int jump(int[] nums) {
        int jump = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);

            if (i == currentEnd) {
                jump++;
                currentEnd = farthest;
            }
        }
        return jump;
    }

    // Q6. N meetings in one room
    public static List<Integer> maxMeeting(int start[], int end[]) {
        List<int[]> meetings = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            meetings.add(new int[]{end[i], start[i], i + 1});
        }

        meetings.sort(Comparator.comparingInt(a -> a[0]));

        List<Integer> result = new ArrayList<>();
        int lastEnd = -1;

        for (int[] m : meetings) {
            if (m[1] > lastEnd) {
                result.add(m[2]);
                lastEnd = m[0];
            }
        }
        return result;
    }
    
    
    
    
    public static void main(String[] args) {
        // Q1
        // int g[] = {1, 2, 3};
        // int s[] = {1, 2};
        // System.out.println(findContentChildren(g, s));  // 2

        // Q2.
        // int value[] = {60, 100, 120};
        // int weight[] = {10, 20, 30};
        // int w = 50;
        // System.out.println(knapsackProblem(value, weight, w));  // 240( 60 + 100 + 80)


        // Q3. 
        // int bills[] = {5, 5, 5, 10, 20};
        // System.out.println(lemonadeChange(bills)); // true

        // Q4.
        // int arr[] = {2,3,1,1,4};
        // // System.out.println(canJump(arr));
        // System.out.println(jump(arr));

        // Q6
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};

        System.out.println(maxMeeting(start, end));
    }
}
