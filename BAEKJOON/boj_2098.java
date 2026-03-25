import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2098 {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    static int N;
    static List<Edge>[] adj;
    static int[][] dp;
    static final int INF = 16000000; 
    
    static int dfs(int curr, int visited) {
        // System.out.println(visited); 
        if (visited == (1 << N) - 1) {
            for (Edge e : adj[curr]) {
                if (e.to == 0) return e.weight;
            }
            return INF;
        }
        
        if (dp[curr][visited] != -1) {
            return dp[curr][visited];
        }
        
        dp[curr][visited] = INF;
        
        for (Edge e : adj[curr]) {
            if ((visited & (1 << e.to)) != 0) continue;
            
            int nextCost = dfs(e.to, visited | (1 << e.to));
            dp[curr][visited] = Math.min(dp[curr][visited], e.weight + nextCost);
        }
        
        return dp[curr][visited];
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[N];
        dp = new int[N][1 << N]; 
        
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
            Arrays.fill(dp[i], -1);
            
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if (weight != 0) {
                    adj[i].add(new Edge(j, weight));
                }
            }
        }
        
        // 수정 1: 0번 도시를 방문했다고 가정하고 시작 (visited = 1)
        int ans = dfs(0, 1); 
        
        System.out.println(ans >= INF ? 0 : ans); 
    }
}