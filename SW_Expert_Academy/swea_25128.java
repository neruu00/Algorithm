import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class swea_25128 {
	static int map[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static int N;
	
	static class Point {
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int BFS(int r, int c) {
		Queue<Point> queue = new ArrayDeque<>();
		int count = 0;
		
		queue.add(new Point(r, c));
		map[r][c] = 0;
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			count++;
						
			for(int d = 0; d < 4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc]==0) continue;
				map[nr][nc] = 0;
				queue.add(new Point(nr, nc));
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];

			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(map[r][c] == 1) sb.append(BFS(r, c)).append(' ');
				}
			}

			sb.append('\n');
		}
		System.out.println(sb);
	}
}
