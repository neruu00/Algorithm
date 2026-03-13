import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class swea_4014_활주로건설 {
	static int N, X;
	static int grid[][];
	
	static boolean checkRow(int r) {
		boolean build[] = new boolean[N];
		
		for(int c = 1; c < N; c++) {
			int diff = grid[r][c] - grid[r][c-1];
			
			if(Math.abs(diff) > 1) return false;
			
			if(diff > 0) {
				for(int j = 0; j < X; j++) {
					int curC = c-1-j;
					
					if(curC < 0) return false;
					if(build[curC]) return false;
					if(grid[r][c-1] != grid[r][curC]) return false;
					
					build[curC] = true;
				}
			} else if(diff < 0) {
				for(int j = 0; j < X; j++) {
					int curC = c+j;
					
					if(curC >= N) return false;
					if(build[curC]) return false;
					if(grid[r][c] != grid[r][curC]) return false;
					
					build[curC] = true;
				}
				c += X-1;
			}
		}
		return true;
	}
	
	static boolean checkColumn(int c) {
		boolean build[] = new boolean[N];
		
		for(int r = 1; r < N; r++) {
			int diff = grid[r][c] - grid[r-1][c];
			
			if(Math.abs(diff) > 1) return false;
			
			if(diff > 0) {
				for(int j = 0; j < X; j++) {
					int curR = r-1-j;
					
					if(curR < 0) return false;
					if(build[curR]) return false;
					if(grid[r-1][c] != grid[curR][c]) return false;
					
					build[curR] = true;
				}
			} else if(diff < 0) {
				for(int j = 0; j < X; j++) {
					int curR = r+j;
					
					if(curR >= N) return false;
					if(build[curR]) return false;
					if(grid[r][c] != grid[curR][c]) return false;
					
					build[curR] = true;
				}
				r += X-1;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			grid = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					grid[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			for(int i = 0; i < N; i++) {
				ans += checkRow(i) ? 1 : 0;
				ans += checkColumn(i) ? 1 : 0;
			}
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
