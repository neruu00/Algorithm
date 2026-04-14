import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_5643_키순서 {
	static int N, M;
	static boolean mat[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			mat = new boolean[N+1][N+1];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				mat[a][b] = true;
			}
			
			for(int k = 1; k <= N; k++) {
				for(int i = 1; i <= N; i++) {
					if((i == k) || !mat[i][k]) continue;
					for(int j = 1; j <= N; j++) {
						if((j == i) || (j == k) || !mat[k][j]) continue;
						mat[i][j] = true;
					}
				}
			}
			
			int ans = 0;
			for(int i = 1; i <= N; i++) {
				int sum = 0;
				for(int j = 1; j <= N; j++) {
					if(mat[i][j] || mat[j][i]) sum++;
				}
				if(sum == N-1) ans++;
			}
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
