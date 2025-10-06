import java.util.*;

public class Main {

    // Function to count round keys in a given binary string
    static int countRoundKeys(String s) {
        int n = s.length();
        int count = 0;

        // Traverse all substrings
        for (int i = 0; i < n; i++) {
            int num = 0;
            for (int j = i; j < n; j++) {
                // Build decimal value on the fly
                num = num * 2 + (s.charAt(j) - '0');
                int len = j - i + 1;

                if (num == len) {
                    count++;
                }

                // Optimization: if num already bigger than length possible,
                // no need to continue further for this substring
                if (num > len + 20) break; 
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array
        int N = sc.nextInt();
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }

        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            result[i] = countRoundKeys(arr[i]);
        }

        // Print output
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}