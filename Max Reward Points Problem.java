import java.util.Scanner;

public class Main {

    // Function to calculate max reward
    public static int findMaxReward(int n, int[] rewards) {
        if (n <= 0 || rewards == null || rewards.length != n) {
            return 0;
        }

        if (n == 1) {
            return Math.max(0, rewards[0]);
        }

        // dp[i][0] = max reward up to index i, not including i
        // dp[i][1] = max reward up to index i, including i
        int[][] dp = new int[n][2];

        // Base case
        dp[0][0] = 0; 
        dp[0][1] = Math.max(0, rewards[0]); 

        for (int i = 1; i < n; i++) {
            // Case 1: not including current element
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

            // Case 2: including current element
            int rewardForCurrent = rewards[i];

            // Apply negative predecessor rule
            if (rewards[i - 1] < 0) {
                rewardForCurrent += rewards[i - 1];
            }

            dp[i][1] = dp[i - 1][0] + rewardForCurrent;

            // Ensure non-negative
            dp[i][1] = Math.max(dp[i][1], 0);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    // Main function with dynamic input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of nodes
        
        int n = sc.nextInt();

        // Input rewards
        int[] rewards = new int[n];
        for (int i = 0; i < n; i++) {
            rewards[i] = sc.nextInt();
        }

        // Call function
        int result = findMaxReward(n, rewards);

        // Output
        System.out.println(result);

        sc.close();
    }
}