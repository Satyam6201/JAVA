import java.util.Arrays;
import java.util.Comparator;

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
    
    
    
    public static void main(String[] args) {
        // Q1
        // int g[] = {1, 2, 3};
        // int s[] = {1, 2};
        // System.out.println(findContentChildren(g, s));  // 2

        // Q2.
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int w = 50;

        System.out.println(knapsackProblem(value, weight, w));  // 240( 60 + 100 + 80)
    }
}
