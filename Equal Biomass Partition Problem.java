import java.util.*;

// Q4: Equal Biomass Partition - Remove edge and check if parts are equal
public class BiomassPartition {
    static List<Integer>[] graph;
    static int[] biomass;
    
    public static int[] solve(int N, int[] bio, int[][] edges) {
        biomass = bio;
        graph = new List[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();
        
        long total = 0;
        for (int b : biomass) total += b;
        if (total % 2 != 0) return new int[]{-1, -1};
        
        // Build graph
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        List<int[]> valid = new ArrayList<>();
        
        // Try removing each edge
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            
            // Remove edge
            graph[u].remove((Integer)v);
            graph[v].remove((Integer)u);
            
            // Check if partition is equal
            boolean[] visited = new boolean[N];
            long sum1 = dfs(u, visited);
            if (sum1 == total / 2) {
                valid.add(new int[]{Math.min(u,v), Math.max(u,v)});
            }
            
            // Restore edge
            graph[u].add(v);
            graph[v].add(u);
        }
        
        if (valid.isEmpty()) return new int[]{-1, -1};
        valid.sort((a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        return valid.get(0);
    }
    
    static long dfs(int node, boolean[] visited) {
        visited[node] = true;
        long sum = biomass[node];
        for (int next : graph[node]) {
            if (!visited[next]) sum += dfs(next, visited);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(4, new int[]{4,2,2,4}, 
            new int[][]{{0,1},{1,2},{2,3}}))); // [1,2]
    }
}