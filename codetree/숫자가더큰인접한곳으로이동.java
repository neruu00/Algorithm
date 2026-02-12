import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 숫자가더큰인접한곳으로이동 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, r, c, grid[][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static void move(int y, int x) {
		int cur = grid[y][x];
		sb.append(cur).append(' ');
		
		for(int d = 0; d < 4; d++) {
			int nr = y + dr[d];
			int nc = x + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
			if(cur < grid[nr][nc]) {
				move(nr, nc);
				break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		grid = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(r, c);
		
		System.out.println(sb);
	}
	
}
