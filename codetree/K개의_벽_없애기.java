import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K개의_벽_없애기 {
	static int N, K, sr, sc, er, ec, ans = Integer.MAX_VALUE;
	static boolean map[][];
	static boolean visited[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
    
    static void dfs(int r, int c, int depth, int count) {
		if(r == er && c == ec) {
			ans = Math.min(ans, depth);
			return;
		}
    	
    	for(int d = 0; d < 4; d++) {
    		int nr = r + dr[d];
			int nc = c + dc[d];
						
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
			
			visited[nr][nc] = true;
			
			if(map[nr][nc]) {
				if(count < K) dfs(nr, nc, depth+1, count+1);
			} else {
				dfs(nr, nc, depth+1, count);
			}
			
			visited[nr][nc] = false;
    	}
    }
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][N];
		visited = new boolean[N][N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken()) == 1;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken()) - 1;
		sc = Integer.parseInt(st.nextToken()) - 1;
		
		st = new StringTokenizer(br.readLine());
		er = Integer.parseInt(st.nextToken()) - 1;
		ec = Integer.parseInt(st.nextToken()) - 1;
		
		visited[sr][sc] = true;
		dfs(sr, sc, 0, 0);
		
		System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
	}
}
