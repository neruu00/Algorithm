import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_75 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int [][] map = new int[N][N];
		int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
		int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
		
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for(int r = 1; r < N-1; r++) {
			for(int c = 1; c < N-1; c++) {
				int sum = 0;
				for(int i = 0; i < 9; i++) {
					sum += map[r+dr[i]][c+dc[i]];
				}
				if(sum > ans) ans = sum;
			}
		}
		System.out.println(ans);
	}
}
