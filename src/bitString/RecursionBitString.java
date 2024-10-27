package bitString;

public class RecursionBitString {
	
	    public static void generateBitStrings(int n, String str) {
	        if (n == 0) {
	            System.out.println(str);
	        } else {
	            generateBitStrings(n - 1, str + "0");
	            generateBitStrings(n - 1, str + "1");
	        }
	    }

	    public static void main(String[] args) {
	        int n = 3;  // length of bit strings
	        generateBitStrings(n, "");
	    }
	

}
