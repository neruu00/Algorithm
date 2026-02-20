import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2638 {
	static int map[][];
	static int N, M;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static class Point {
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static void checkOutside() {
		Queue<Point> queue = new ArrayDeque<>();
		boolean visited[][] = new boolean[N][M];
		
		queue.offer(new Point(0, 0));
		visited[0][0] = true;
		
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
									
			map[p.r][p.c] = 2;
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				visited[nr][nc] = true;
				if(map[nr][nc] != 1) queue.offer(new Point(nr, nc));
			}
		}
	}
	
	static boolean melt() {
		List<Point> remove = new ArrayList<>();
		
		checkOutside();
		
		for(int r = 1; r < N-1; r++) {
			for(int c = 1; c < M-1; c++) {
				if(map[r][c] != 1) continue;
				
				int outside = 0;
				
				for(int d = 0; d < 4; d++) {
					int nr = r+dr[d];
					int nc = c+dc[d];
					if(map[nr][nc] == 2) outside++;
				}
				if(outside >= 2) remove.add(new Point(r, c));
			}
		}
		
		for(Point p:remove) map[p.r][p.c] = 0;
		
		return remove.size() > 0;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		while(melt()) ans++;
		
		System.out.println(ans);
	}
}
