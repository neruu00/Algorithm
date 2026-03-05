import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최단_경로로_탈출_하기 {
	static int N, M;
	static boolean map[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};
	
	static class Point {
		int r, c;
		Point(int r, int c) {
			this.r = r; this.c = c;
		}
	}
	
	static int bfs() {
		Queue<Point> q = new ArrayDeque<>();
		q.offer(new Point(0, 0));
		map[0][0] = true;
		
		int count = 1;
		int time = 0;
		while(!q.isEmpty()) {
			if(count == 0) {
				count = q.size();
				time++;
			}
			count--;
			
			Point p = q.poll();
			for(int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc]) continue;
				if(nr == N-1 && nc == M-1) return time + 1;
				
				map[nr][nc] = true;
				q.offer(new Point(nr, nc));
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken()) == 0;
			}
		}
		
		System.out.println(bfs());
	}
}
