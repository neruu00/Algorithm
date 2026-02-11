import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2001 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N+1][N+1];
			
			for(int r = 1; r <= N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 1; c <= N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken()) + map[r-1][c] + map[r][c-1] - map[r-1][c-1];
				}
			}
			
			int ans = 0;
			for(int r = M; r <= N; r++) {
				for(int c = M; c <= N; c++) {
					int sum = map[r][c] - map[r-M][c] - map[r][c-M] + map[r-M][c-M];
					if(sum > ans) ans = sum;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
