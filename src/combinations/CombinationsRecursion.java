package combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationsRecursion {

	public static void generateCombinations(int[] arr, int start, List<Integer> combination, int k) {
		if (combination.size() == k) {
			System.out.println(combination);
			return;
		}

		for (int i = start; i < arr.length; i++) {
			combination.add(arr[i]);
			generateCombinations(arr, i + 1, combination, k);
			combination.remove(combination.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int k = 2; // size of combinations
		generateCombinations(arr, 0, new ArrayList<>(), k);
	}

}
