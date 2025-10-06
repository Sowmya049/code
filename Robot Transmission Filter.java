import java.util.*;

public class SignalPatterns {

    public static int countDistinctPatterns(int N, int K, int[] A) {
        Set<String> patterns = new HashSet<>();

        for (int i = 0; i <= N - K; i++) {
            StringBuilder sb = new StringBuilder();

            // Append elements before the block
            for (int j = 0; j < i; j++) {
                sb.append(A[j]).append(",");
            }

            // Append elements after the block
            for (int j = i + K; j < N; j++) {
                sb.append(A[j]).append(",");
            }

            patterns.add(sb.toString());
        }

        return patterns.size();
    }

    public static void main(String[] args) {
        int[] A1 = {5, 6, 1, 2};
        System.out.println(countDistinctPatterns(4, 2, A1)); // Output: 3

        int[] A2 = {17, 5, 8, 12, 10, 8, 5};
        System.out.println(countDistinctPatterns(7, 3, A2)); // Output: 4
    }
}