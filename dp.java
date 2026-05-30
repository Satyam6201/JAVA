import java.util.Arrays;
import java.util.List;

public class dp {

    // Q1. Stair Problem
    public static void stair(int n) {
        int dp[] = new int[n + 1];

        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        System.out.println(dp[n]);
    }
    
    // Q2. Frog Jump 
    public static int frogJump(int arr[]) {
        if (arr == null || arr.length == 1) {
            return 0;
        }

        int n = arr.length;
        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int jumpTwo = Integer.MAX_VALUE;

            int jumpOne = prev + Math.abs(arr[i] - arr[i - 1]);

            if (i > 1) {
                jumpTwo = prev2 + Math.abs(arr[i] - arr[i - 2]);
            }

            int curr = Math.min(jumpOne, jumpTwo);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    
    // Q3. House Robber
    public static int rob(int arr[]) {
        int n = arr.length;

        if (n == 0) return 0;
        if (n == 1) return arr[0];

        int dp[] = new int[n];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        return dp[n - 1];
    }
    
    // Q4. Unique Paths
    public static int uniquePath(int m, int n) {
        long res = 1;

        for (int i = 1; i <= m - 1; i++) {
            res = res * (n - 1 + i) / i;
        }
        return (int)res;
    }
    
    // Q5.  Triangle(leetcode 120)
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int dp[] = new int[n];

        // for the last row of the triangle 
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }
        return dp[0];
    }
    
    // 6. Count Square Submatrices with All Ones
    public static int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;

        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }

                    count += dp[i][j];
                }
            }
        }
        return count;
    }

    // Q7. Target Sum (DP - 21)
    public static int findTargetSumWays(int nums[], int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if ((target + total) % 2 != 0 || Math.abs(target) > total) {
            return 0;
        }

        int newTotal = (total + target) / 2;
        int dp[] = new int[newTotal + 1];

        dp[0] = 1;

        for (int num: nums) {
            for (int j = newTotal; j >= num; j--) {
                dp[j] += dp[j - num];
            } 
        }

        return dp[newTotal];
    }
    
    // Q8.  Partition Equal Subset Sum
    public static boolean canPartition(int nums[]) {
        int sum = 0;

        for (int num: nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        boolean dp[] = new boolean[target + 1];

        for (int num: nums) {
            int newNum = num;

            for (int j = target; j >= newNum; j--) {
                dp[j] = dp[j] || dp[j - newNum];
            }
        }

        return dp[target];
    }
    public static void main(String[] args) {
        // Q1
        // int n = 4;
        // stair(n);  // 5

        // Q2
        // int arr[] = {30, 10, 60, 10, 60, 50};
        // System.out.println(frogJump(arr));  // 40

        // Q3. 
        // int arr[] = {1, 2, 3, 1};
        // System.out.println(rob(arr));  // 4

        // Q4.
        // System.out.println(uniquePath(3, 2));  // 3

        // Q5.
        // List<List<Integer>> triangle = new ArrayList<>();
        // triangle.add(Arrays.asList(2));
        // triangle.add(Arrays.asList(3, 4));
        // triangle.add(Arrays.asList(6, 5, 7));
        // triangle.add(Arrays.asList(4, 1, 8, 3));
        // System.out.println(minimumTotal(triangle));

        // Q6.
        // int[][] arr = {
        //     {0, 1, 1, 1},
        //     {1, 1, 1, 1},
        //     {0, 1, 1, 1}
        // };
        // System.out.println(countSquares(arr));

        // Q7.
        // int[] nums = {1, 1, 1, 1, 1};
        // int target = 3;
        // System.out.println(findTargetSumWays(nums, target));

        // Q8. 
        int nums[] = {1, 5, 11, 5};
        System.out.println(canPartition(nums));


    }
}