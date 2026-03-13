import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 
 * 메모리:29,568kb, 시간:156ms
 *
 */

public class swea_1249_보급로 {
	static class Point implements Comparable<Point>{
		int r, c, w;
		Point(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.w - o.w;
		}
	}
	
	static int N;
	static int grid[][];
	static int minDist[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static int bfs() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		pq.offer(new Point(0, 0, 0));
		minDist[0][0] = 0;
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			
			if(p.w > minDist[p.r][p.c]) continue;
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				int dist = p.w + grid[nr][nc];
								
				if(minDist[nr][nc] > dist) {
					minDist[nr][nc] = dist;
					pq.offer(new Point(nr, nc, minDist[nr][nc]));
				}
			}
		}
		
		return minDist[N-1][N-1];
	}
	
	public static void main(String[] args) throws Exception {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			grid = new int[N][N];
			minDist = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				String str = br.readLine();
				for(int c = 0; c < N; c++) {
					grid[r][c] = str.charAt(c) - '0';
					minDist[r][c] = Integer.MAX_VALUE;
				}
			}
			
			sb.append('#').append(tc).append(' ').append(bfs()).append('\n');
		}
		System.out.println(sb);
	}
}
