import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 네_방향_탈출_가능_여부_판별하기 {
	static int N, M;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	static boolean map[][];
	
	static class Point {
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(0, 0));
		map[0][0] = true;

		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M ) continue;
				
				if(nr == N-1 && nc == M-1) return 1;
				
				if(map[nr][nc]) continue;

				map[nr][nc] = true;
				queue.offer(new Point(nr, nc));
			}
		}
		return 0;
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
				map[r][c] = Integer.parseInt(st.nextToken()) == 0; // true 뱀 있음, false 뱀 없음
			}
		}
		
		System.out.println(bfs());
	}
}
