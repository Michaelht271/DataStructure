package permutations;
import java.util.Arrays;

public class PermutationsNonRecursive {
    public static void generatePermutations(int[] arr) {
        Arrays.sort(arr);
        do {
            System.out.println(Arrays.toString(arr));
        } while (nextPermutation(arr));
    }

    // Helper method to generate the next lexicographical permutation
    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        if (i < 0) return false;

        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        swap(arr, i, j);
        reverse(arr, i + 1);
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start) {
        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        generatePermutations(arr);
    }
}
