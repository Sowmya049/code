import java.util.*;

public class Main {
    static final int MOD = 1000000007;

    // Mapping from char -> list of integers
    static Map<Character, int[]> map = new HashMap<>();
    static long totalSum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input1 = sc.next();
        sc.close();

        // Initialize mapping
        map.put('a', new int[]{1, 2});
        map.put('b', new int[]{3, 4});
        map.put('c', new int[]{5, 6});
        map.put('d', new int[]{7, 8});
        map.put('e', new int[]{9, 10, 11});
        map.put('f', new int[]{12, 13});
        map.put('g', new int[]{14, 15});
        map.put('h', new int[]{16});

        // Call recursion
        solve(input1, 0, 0);

        // Print result
        System.out.println(totalSum % MOD);
    }

    // Recursive function
   static void solve(String s, int index, long currsum){
       if(index==s.length()){
           totalSum=(currsum+totalSum)% MOD;
           return ;
       }
       char ch=s.charAt(index);
       int[] values=map.get(ch);
       for(int val:values){
           solve(s, index+1, currsum+val);
       }
   }
}