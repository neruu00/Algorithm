import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.omg.CORBA.INTERNAL;

public class swea_5656_벽돌깨기 {
	static int N, W, H, ans;
	static int grid[][][];
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static void init(int depth) {
		for(int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++) {
				grid[depth][r][c] = grid[depth-1][r][c];
			}
		}
	}
	
	static void attack(int depth, int r, int c) {
		int num = grid[depth][r][c];
		grid[depth][r][c] = 0;
		
		for(int d = 0; d < 4; d++) {
			int nr = r;
			int nc = c;
			
			for(int i = 0; i < num-1; i++) {
				nr += dr[d];
				nc += dc[d];
				
				if(nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
								
				if(grid[depth][nr][nc] != 0) attack(depth, nr, nc);
			}
		}
	}
	
	static void fall(int depth) {
	    for(int c = 0; c < W; c++) {
	        int emptyRow = H - 1;
	        for(int r = H - 1; r >= 0; r--) {
	            if(grid[depth][r][c] > 0) {
	                if(r != emptyRow) {
	                    grid[depth][emptyRow][c] = grid[depth][r][c];
	                    grid[depth][r][c] = 0;
	                }
	                emptyRow--;
	            }
	        }
	    }
	}
	
	
	static void check(int depth) { 
		int sum = 0;
		for(int r = 0; r < H; r++) {
			for(int c = 0; c < W; c++) {
				int num = grid[depth][r][c];
				if(num > 0) sum++;
			}
		}
		ans = Math.min(ans, sum);
	}
	
	static void simulate(int depth) {
		for(int c = 0; c < W; c++) {
			init(depth);
			
			for(int r = 0; r < H; r++) {
				if(grid[depth][r][c] == 0) continue;
				attack(depth, r, c);
				fall(depth);
				break;
			}
			
			if(depth == N) check(depth);
			else simulate(depth+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			grid = new int[5][H][W];

			ans = 0;
			for(int r = 0; r < H; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < W; c++) {
					grid[0][r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = Integer.MAX_VALUE;
			simulate(1);
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
