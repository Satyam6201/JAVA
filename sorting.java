public class sorting {

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
    public static void main(String[] args) {
        // int n = 36;
        // findSqur(28);

        nthRoot(3, 27); // 3
        nthRoot(4, 69);  // -1 (not found)

    }
}