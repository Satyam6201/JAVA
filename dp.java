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
    
    
    public static void main(String[] args) {
        // Q1
        // int n = 4;
        // stair(n);

        // Q2
        int arr[] = {30, 10, 60, 10, 60, 50};
        System.out.println(frogJump(arr));
    }
}