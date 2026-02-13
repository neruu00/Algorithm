import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17472_dfs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, land, ans, map[][], markMap[][];
	static int bridges[][];
	static boolean used[][];
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
				
				if(mark == 0) continue;
				
				if(mark != 0 && dist < 2) break;
				
				int min = bridges[n][mark] > 0 ? Math.min(bridges[n][mark], dist) : dist;
				bridges[n][mark] = bridges[mark][n] = min;
				break;
			}
		}
	}
		
	static void dfs(int depth, int dist) {
		if(bfs()) {
			ans = Math.min(ans, dist);
			return;
		}
		
		if(depth == land) return;
			
		for(int r = 1; r <= land; r++) {
			for(int c = 1; c <= land; c++) {
				if(r == c || used[r][c]) continue;
				int nextDist = bridges[r][c];
				if(nextDist > 0) {
					used[r][c] = used[c][r] = true;
					dfs(depth+1, dist+nextDist);
					used[r][c] = used[c][r] = false;
				}
			}
		}
	}
	
	static boolean bfs() {
		boolean visited[] = new boolean[land+1];
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		queue.offer(1);
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			
			for(int i = 1; i <= land; i++) {
				if(!used[tmp][i]) continue;
				if(visited[i]) continue;
				int next = bridges[tmp][i];
				if(next > 0) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		
		for(int i = 1; i <= land; i++) {
			if(!visited[i]) return false;
		}
		return true;
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
				if(map[r][c] == 1) {
					marking(r, c, ++land);
				}
			}
		}
		
		bridges = new int[land+1][land+1];
		used = new boolean[land+1][land+1];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				int mark = markMap[r][c];
				if(mark > 0) findBridge(r, c, mark);
			}
		}
		
		dfs(0, 0);
		
		if(ans != Integer.MAX_VALUE) System.out.println(ans);
		else System.out.println(-1);
	}
}
