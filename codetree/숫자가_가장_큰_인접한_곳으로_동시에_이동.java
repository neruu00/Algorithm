import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자가_가장_큰_인접한_곳으로_동시에_이동 {
	static int map[][];
	static int beads[][];
	static int temp[][];
	static Point next[][];
	static int N, M, T, ans;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static class Point {
		int r, c;
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static void setNext(int r, int c) {
		int max = 0;
		int dir = 0;
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(map[nr][nc] > max) {
				max = map[nr][nc];
				dir = d;
			}
		}
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		next[r][c] = new Point(nr, nc);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		beads = new int[N][N];
		temp = new int[N][N];
		next = new Point[N][N];
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				setNext(r, c);
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			beads[r][c]++;
		}
		
		for(int t = 0; t < T; t++) {
			ans = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(beads[r][c] == 0) continue;
					beads[r][c]--;
					int nr = next[r][c].r;
					int nc = next[r][c].c;
					temp[nr][nc]++;
				}
			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(temp[r][c] == 0) continue;
					if(temp[r][c] == 1) {
						beads[r][c] = 1;
						ans++;
					}
					temp[r][c] = 0;
					
				}
			}
		}
		System.out.println(ans);
	}
}
