import java.util.*;

public class SmallBigToysSecondNegative {

    public static int secondNegativeSuffix(int N, int[] A) {
        // Collect all small toys (even values)
        List<Integer> smallToys = new ArrayList<>();
        for (int val : A) {
            if (val % 2 == 0) {
                smallToys.add(val);
            }
        }

        // Sort small toys in descending order to maximize suffix sums
        Collections.sort(smallToys, Collections.reverseOrder());

        // Place sorted small toys back into the array at positions of even numbers
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] % 2 == 0) {
                A[i] = smallToys.get(idx++);
            }
        }

        // Compute suffix sums from right and track negative indices
        long suffixSum = 0;
        List<Integer> negativeIndices = new ArrayList<>();
        for (int i = N - 1; i >= 0; i--) {
            suffixSum += A[i];
            if (suffixSum < 0) {
                negativeIndices.add(i);
            }
        }

        // Return the second earliest negative index from left (if exists)
        if (negativeIndices.size() < 2) {
            return -1; // less than 2 negative suffixes
        } else {
            return negativeIndices.get(negativeIndices.size() - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        sc.close();

        System.out.println(secondNegativeSuffix(N, A));
    }
}