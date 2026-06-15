import java.util.*;

public class revision {
    public static void removeDuplicate(int arr[]) {
       int n = arr.length;
       int rightMax = -1;

       for (int i = n - 1; i >= 0; i--) {
        int current = arr[i];
        arr[i] = rightMax;

            if (current > rightMax) {
                rightMax = current;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        int num[] = {2, 3, 6, 7};
        removeDuplicate(arr);
    }
}