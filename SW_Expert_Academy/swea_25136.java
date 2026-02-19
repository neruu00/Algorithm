import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_25136 {
	static char map[][];
	static boolean visited[][];
	static int N, ans;
	static Point h, s;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static class Point {
		int r, c, time;
		Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	
	static void BFS() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(h);
		visited[h.r][h.c] = true;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			if(cur.r == s.r && cur.c == s.c) {
				ans = cur.time;
				return;
			}
						
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 'X') continue;
				visited[nr][nc] = true;
				queue.add(new Point(nr, nc, cur.time+1));
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
			
			map = new char[N][N];
			visited = new boolean[N][N];

			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = st.nextToken().charAt(0);
					if(map[r][c] == 'H') h = new Point(r, c, 0);
					if(map[r][c] == 'S') s = new Point(r, c, 0);
				}
			}
			ans = -1;
			BFS();
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
