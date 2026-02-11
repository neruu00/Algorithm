import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_1954 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int [N][N];
			
			int preR = 0, preC = -1, d = 0;
			for(int i = 1; i <= N*N; i++) {
				int curR = preR + dr[d];
				int curC = preC + dc[d];
				if(curR < 0 || curR >= N || curC < 0 || curC >= N || map[curR][curC] != 0) {
					d = (d + 1) % 4;
					curR = preR + dr[d];
					curC = preC + dc[d];
				}
				map[curR][curC] = i;
				preR = curR;
				preC = curC;
			}
			
			System.out.println("#"+tc);
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					System.out.print(map[r][c]+" ");
				}
				System.out.println();
			}
		}
	}
}
