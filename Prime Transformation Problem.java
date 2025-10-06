import java.util.*;

// Q3: Prime Transformation - BFS to find smallest prime
public class PrimeTransformation {
    public static int solve(int N, int K) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.add(N + ":" + 0); // number:operations

        int minPrime = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            String[] parts = q.poll().split(":");
            String num = parts[0];
            int ops = Integer.parseInt(parts[1]);

            if (!num.startsWith("0") && isPrime(Integer.parseInt(num))) {
                minPrime = Math.min(minPrime, Integer.parseInt(num));
            }

            if (ops < K) {
                for (int i = 0; i < num.length(); i++) {
                    char[] arr = num.toCharArray();
                    int digit = arr[i] - '0';

                    // +1 and -1 operations
                    if (digit < 9) {
                        arr[i] = (char) (digit + 1 + '0');
                        String next = new String(arr) + ":" + (ops + 1);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.add(next);
                        }
                    }
                    if (digit > 0) {
                        arr[i] = (char) (digit - 1 + '0');
                        String next = new String(arr) + ":" + (ops + 1);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            q.add(next);
                        }
                    }
                }
            }
        }
        return minPrime == Integer.MAX_VALUE ? -1 : minPrime;
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
    
        int K = sc.nextInt();

        int result = solve(N, K);
        System.out.println(result);
        
        sc.close();
    }
}