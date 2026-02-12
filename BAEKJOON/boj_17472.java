import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17472 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, land, ans, map[][], markMap[][];
	static boolean visited[];
	static int bridges[][];
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, -1, 0, 1};
	
	static void marking(int r, int c, int n) {
		if(r < 0 || r >= N || c < 0 || c >= M || map[r][c] != 1) return;
		
		map[r][c] = 0;
		markMap[r][c] = n;
		marking(r-1, c, n);
		marking(r+1, c, n);
		marking(r, c-1, n);
		marking(r, c+1, n);
	}
	
	static void findBridge(int r, int c, int n) {
		for(int d = 0; d < 4; d++) {
			int dist = -1;
			int nr = r;
			int nc = c;
			
			while(true) {
				nr += dr[d];
				nc += dc[d];
				dist++;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) break;
				
				int mark = markMap[nr][nc];
				
				if(mark == n) break;
				
				if(mark != 0) {
					if(dist < 2) break;
					int min = bridges[n][mark] > 0 ? Math.min(bridges[n][mark], dist) : dist;
					bridges[n][mark] = bridges[mark][n] = min;
				}
			}
		}
	}
	
	static void dfs(int mark, int depth, int dist) {
		if(depth == land) {
			ans = Math.min(ans, dist);
			return;
		}
		
		if(visited[mark]) return;
		
		for(int i = 1; i <= land; i++) {
			int nextDist = bridges[mark][i];
			if(nextDist > 0) {
				visited[i] = true;
				dfs(i, depth+1, dist+nextDist);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		markMap = new int[N][M];
		ans = Integer.MAX_VALUE;
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		land = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				if(map[r][c] == 1 && markMap[r][c] == 0) {
					marking(r, c, ++land);
				}
			}
		}
		
		bridges = new int[land+1][land+1];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				int mark = markMap[r][c];
				if(mark > 0) findBridge(r, c, mark);
			}
		}
		
		visited = new boolean[land+1];
		
		if(ans != Integer.MAX_VALUE) System.out.println(ans);
		else System.out.println(-1);
	}
}
