import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14502 {
	static class Point{
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, ans, maxCnt;
	static int map[][], tempMap[][];
	static List<Point> poisons = new ArrayList<>();
	static Queue<Point> queue = new ArrayDeque<>();
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static void init() {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < M; c++) {
				tempMap[r][c] = map[r][c];
			}
		}
	}
	
	static void simulate() {
		for(Point p : poisons) queue.offer(p);
		
		int cnt = maxCnt-3;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || tempMap[nr][nc] > 0) continue;
				
				cnt--;
				tempMap[nr][nc] = 2;
				queue.offer(new Point(nr, nc));
			}
		}
		
		ans = Math.max(ans, cnt);
	}
	
	static void perm(int sr, int sc, int depth) {
		if(depth == 3) {
			init();
			simulate();
			return;
		}
		
		for(int r = sr; r < N; r++) {
			for(int c = (r == sr) ? sc : 0; c < M; c++) {
				if(map[r][c] != 0) continue;
				map[r][c] = 1;
				perm(r, c+1, depth+1);
				map[r][c] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		tempMap = new int[N][M];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp != 0) map[r][c] = tmp;
				else maxCnt++;
				if(tmp == 2) poisons.add(new Point(r, c));
			}
		}
		
		perm(0, 0, 0);
		
		System.out.println(ans);
	}
}
