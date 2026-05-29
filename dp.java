import java.util.Arrays;

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
    public static void main(String[] args) {
        // Q1
        // int n = 4;
        // stair(n);  // 5

        // Q2
        // int arr[] = {30, 10, 60, 10, 60, 50};
        // System.out.println(frogJump(arr));  // 40

        // Q3. 
        // int arr[] = {1, 2, 3, 1};
        // System.out.println(rob(arr));

        // Q4.
        System.out.println(uniquePath(3, 2));

    }
}