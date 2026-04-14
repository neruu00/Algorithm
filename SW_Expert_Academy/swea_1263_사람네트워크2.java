import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1263_사람네트워크2 {
	static final int INF = 10000;
	static int mat[][];
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			mat = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					mat[r][c] = Integer.parseInt(st.nextToken());
					if((r != c) && (mat[r][c] == 0)) mat[r][c] = INF;
				}
			}
			
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					if((i == k) || (mat[i][k] == INF)) continue;
					for(int j = 0; j < N; j++) {
						if((j == k) || (j == i) || (mat[k][j] == INF)) continue;
						mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
					}
				}
			}
			
			int minSum = Integer.MAX_VALUE;
			
			for(int r = 0; r < N; r++) {
				int sum = 0;
				
				for(int c = 0; c < N; c++) {
					sum += mat[r][c];
				}
				
				if(sum < minSum) minSum = sum;
			}
			
			sb.append('#').append(tc).append(' ').append(minSum).append('\n');
		}
		System.out.println(sb);
	}
}
