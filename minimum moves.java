Q5. Minimum Move
Code
import java.util.*;

public class Main {
    
    public static int minMoves(int N, int[] E, int K) {
        // Convert to 0-based index
        int start = K - 1;

        // If already at hospital
        if (E[start] == 0) return 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.offer(start);
        visited[start] = true;

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++; // one move level

            for (int s = 0; s < size; s++) {
                int curr = queue.poll();

                // possible next positions
                int left = curr - E[curr];
                int right = curr + E[curr];

                // check left move
                if (left >= 0 && !visited[left]) {
                    if (E[left] == 0) return moves;
                    queue.offer(left);
                    visited[left] = true;
                }

                // check right move
                if (right < N && !visited[right]) {
                    if (E[right] == 0) return moves;
                    queue.offer(right);
                    visited[right] = true;
                }
            }
        }

        return -1; // not reachable
    }

    public static void main(String[] args) {
        // Example 1
        int N1 = 4;
        int[] E1 = {2,1,0,1};
        int K1 = 1;
        System.out.println(minMoves(N1, E1, K1)); // Output: 1

        // Example 2
        int N2 = 4;
        int[] E2 = {3,2,0,2};
        int K2 = 2;
        System.out.println(minMoves(N2, E2, K2)); // Output: -1
    }
}