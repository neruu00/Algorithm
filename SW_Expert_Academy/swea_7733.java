import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_7733 {
	static int cheese[][];
	static boolean visited[][];
	static int N, ans, max;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static void BFS(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[]{r, c});
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || cheese[nr][nc] == 0) continue;
				visited[nr][nc] = true;
				queue.offer(new int[] {nr, nc});
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
			
			cheese = new int[N][N];
			visited = new boolean[N][N];

			max = Integer.MIN_VALUE;
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					cheese[r][c] = Integer.parseInt(st.nextToken());
					max = Math.max(max, cheese[r][c]);
				}
			}
			
			ans = 1;
			
			for(int i = 1; i < max; i++) {
				
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						if(cheese[r][c] == i) cheese[r][c] = 0;
					}
				}
				
				int count = 0;
				visited = new boolean[N][N];
				
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						if(cheese[r][c] == 0 || visited[r][c]) continue;
						count++;
						BFS(r, c);
					}
				}
				
				ans = Math.max(ans, count);
			}
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
