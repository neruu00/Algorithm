import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class swea_2819_격자판의숫자이어붙이기 {
	static int grid[][];
	static Set<Integer> set;
	static int dr[] = {-1, 1, 0, 0};
	static int dc[] = {0, 0, -1, 1};
	
	static void simulate(int r, int c, int depth, int result) {
		if(depth == 6) {
			set.add(result);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;
			
			simulate(nr, nc, depth+1, result*10+grid[nr][nc]);
		}
	};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			grid = new int[4][4];
			set = new HashSet<>();
			
			for(int r = 0; r < 4; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < 4; c++) {
					grid[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int r = 0; r < 4; r++) {
				for(int c = 0; c < 4; c++) {
					simulate(r, c, 0, grid[r][c]);
				}
			}
			
			sb.append(set.size()).append('\n');
		}
		System.out.println(sb);
	}
}
