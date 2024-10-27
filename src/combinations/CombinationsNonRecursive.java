package combinations;

import java.util.Arrays;

public class CombinationsNonRecursive {
    public static void generateCombinations(int[] arr, int k) {
        int n = arr.length;
        int[] combination = new int[k];

        // Initialize with the first combination
        for (int i = 0; i < k; i++) {
            combination[i] = i;
        }

        while (combination[k - 1] < n) {
            // Print current combination
            System.out.println(Arrays.toString(Arrays.stream(combination).map(i -> arr[i]).toArray()));

            // Generate next combination
            int t = k - 1;
            while (t != 0 && combination[t] == n - k + t) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < k; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 2;  // size of combinations
        generateCombinations(arr, k);
    }
}
