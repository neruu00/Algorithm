import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16236 {
	static int N, cr, cc, cSize, eat, ans;
	static int grid[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static boolean bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean visited[][] = new boolean[N][N];
		
		queue.offer(new int[] {cr, cc, 0});
		visited[cr][cc] = true;
		
		int minTime = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {						
			int[] p = queue.poll();
			int r = p[0];
			int c = p[1];
			int time = p[2];
						
			int cell = grid[r][c];
			if(cell > 0 && cSize > cell) {
				if(time < minTime) {
					minTime = time;
					cr = r;
					cc = c;
				} else if(time == minTime && r < cr) {
					minTime = time;
					cr = r;
					cc = c;
				} else if(time == minTime && r == cr && c < cc) {
					minTime = time;
					cr = r;
					cc = c;
				}
			}
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || grid[nr][nc] > cSize) continue;
								
				visited[nr][nc] = true;

				if(time < minTime) queue.offer(new int[] {nr, nc, time+1});
			}
		}
		
		if(minTime != Integer.MAX_VALUE) {
			ans += minTime;
			grid[cr][cc] = 0;
			if(++eat == cSize) {
				cSize++;
				eat = 0;
			}
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		grid = new int[N][N];
		cSize = 2;
		eat = 0;
		
		for(int r = 0; r < N; r++) {
			st = new  StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				grid[r][c] = Integer.parseInt(st.nextToken());
				if(grid[r][c] == 9) {
					grid[r][c] = 0;
					cr = r;
					cc = c;
				}
			}
		}
		while(bfs());
		System.out.println(ans);
	}
}
