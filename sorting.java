public class sorting {

    //1. find squr of the n number
    public static void findSqur(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int indexVal = i * i;

            if (indexVal <= n) {
                ans = i;
            }
            else {
                break;
            }
        }
        System.out.println(ans);
    }

    //2. find nth root(power of i^n == m)
    public static void nthRoot(int n, int m) {
        for (int i = 1; i <= m; i++) {
           long pow = (long) Math.pow(i, n);

           if (pow == m) {
            System.out.println(i);
            return;
           }
           if (pow > m) {
            break;
           }
        }
        System.out.println(-1);
    }

    //3. find kth missing number
    public static void kthMissingNum(int arr[], int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                k++;
            }
            else {
                break;
            }
        }
        System.out.println(k);
    }

    // 4. Find the max 1's in the matrix
    public static void rowWithMax1s(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxOne = 0;
        int index = -1;  // to find the index

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }

            if (count > maxOne) {
                maxOne = count;
                index = i;
            }
        }
        
        if (index > 0) {
            System.out.println("1's = " + index + " Max 1's = " + maxOne);
        }
        else {
            System.out.println("1 is not present!");
        }
    }
    
    // 5. search in 2d Array (matrix[i][j] == target return true else false)
    public static boolean searchArray(int matrix[][], int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // or Binary search approach
    public static boolean searchArrayS(int matrix[][], int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int left = 0;
        int right = n * m - 1;  // total value = 3 * 4-1 = 12 - 1 (from 0 to 11)

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / m;
            int col = mid % m;
            int midvalue = matrix[row][col];

            if (midvalue == target) {
                return true;
            }
            else if (midvalue < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        // int n = 36;
        // findSqur(28);

        // nthRoot(3, 27); // 3
        // nthRoot(4, 69);  // -1 (not found)

        // int arr[] = {4, 7, 9, 10};
        // int k = 4;
        // kthMissingNum(arr, 2);

        // int[][] matrix = {
        //         {0,0,0,1,1},
        //         {0,0,1,1,1},
        //         {0,0,0,0,0},
        //         {0,1,1,1,1}
        // };
        // rowWithMax1s(matrix);

        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        // System.out.println(searchArray(matrix, 3)); // true
        // System.out.println(searchArrayS(matrix, 3)); // true
        System.out.println(searchArrayS(matrix, 15));  // false
    }
}