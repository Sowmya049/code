import java.util.*;

public class Main {

    public static int[] legostring(String input1, int input2, String[] input3) {
        String S = input1;
        int N = input2;
        String[] B = input3;

        List<Integer> result = new ArrayList<>();

        // Try each starting index in S
        for (int start = 0; start < S.length(); start++) {
            Set<Integer> used = new HashSet<>();
            if (canForm(S, B, start, used, 0)) {
                result.add(start);
            }
        }

        if (result.isEmpty()) return new int[]{-1};
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // Backtracking function to check if from pos we can form a chain using >=2 blocks
    private static boolean canForm(String S, String[] blocks, int pos, Set<Integer> used, int usedCount) {
        if (usedCount >= 2) return true; // valid chain

        if (pos >= S.length()) return false;

        for (int i = 0; i < blocks.length; i++) {
            if (!used.contains(i)) {
                String b = blocks[i];
                if (pos + b.length() <= S.length() && S.startsWith(b, pos)) {
                    used.add(i);
                    if (canForm(S, blocks, pos + b.length(), used, usedCount + 1)) {
                        return true;
                    }
                    used.remove(i); // backtrack
                }
            }
        }
        return false;
    }

    // Example run
    public static void main(String[] args) {
        String S = "thespiderman";
        int N = 4;
        String[] B = {"th", "id", "es", "er"};

        int[] ans = legostring(S, N, B);
        System.out.println(Arrays.toString(ans));  // [0, 5]
    }
}