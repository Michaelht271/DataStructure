package bitString;

public class BitStringsNonRecursive {
    public static void generateBitStrings(int n) {
        int total = (1 << n); // 2^n
        for (int i = 0; i < total; i++) {
            StringBuilder bitString = new StringBuilder();
            for (int j = n - 1; j >= 0; j--) {
                bitString.append((i & (1 << j)) == 0 ? '0' : '1');
            }
            System.out.println(bitString.toString());
        }
    }

    public static void main(String[] args) {
        int n = 3;  // length of bit strings
        generateBitStrings(n);
    }
}

