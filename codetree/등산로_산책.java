import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 등산로_산책 {
	static int N, K, highest, ans;
	static int map[][];
	static boolean visited[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	static void dfs(int r, int c, int k, int last, int len) {
		if (k < 0) return;

		ans = Math.max(ans, len);

		if (last == 1) return;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == highest) continue;
			
			int diff = last - map[nr][nc] - 1;
			
			visited[nr][nc] = true;
			
			if (diff >= 0) dfs(nr, nc, k, map[nr][nc], len + 1);
			else dfs(nr, nc, k + diff, last - 1, len + 1);
			
			visited[nr][nc] = false;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				highest = Math.max(highest, map[r][c]);
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == highest) dfs(r, c, K, map[r][c], 1);
			}
		}

		System.out.println(ans);
	}
}
