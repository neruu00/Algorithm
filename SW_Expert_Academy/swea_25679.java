import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_25679 {
	static int N, cr, cc, ans;
	static boolean map[][];
	static boolean visited[][];
	static boolean catched[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static void dfs(int r, int c, int depth) {
		if(depth == 3) return;
		
		A : for(int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			while(true) {
				nr += dr[d];
				nc += dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue A;
				if(map[nr][nc] && !visited[nr][nc]) break;
			}
			while(true) {
				nr += dr[d];
				nc += dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue A;
				if(map[nr][nc] && !visited[nr][nc]) {
					visited[nr][nc] = true;
					catched[nr][nc] = true;
					dfs(nr, nc, depth+1);
					visited[nr][nc] = false;
					break;
				} else {
					dfs(nr, nc, depth+1);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new boolean[N][N];
			visited = new boolean[N][N];
			catched = new boolean[N][N];
			
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp == 1) map[r][c] = true;
					else if(tmp == 2) {
						cr = r;
						cc = c;
					}
				}
			}
			
			ans = 0;
			dfs(cr, cc, 0);
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					ans += catched[r][c] ? 1 : 0;
				}
			}
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
