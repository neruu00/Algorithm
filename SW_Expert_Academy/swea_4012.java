import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4012 {
	static int syn[][];
	static int N, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			ans = Integer.MAX_VALUE;
			syn = new int[N][N];
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					syn[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 0, 0);
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int bits, int depth, int count) {
		 if(depth == N) return; 
		 if(count == N/2) {
			 int a = getTaste(bits);
			 int b = getTaste(~bits);
			 int diff = Math.abs(a - b);	 
			 if(diff < ans) ans = diff;
			 return;
		 }
		 
		 dfs(bits | 1 << depth, depth+1, count+1);
		 dfs(bits, depth+1, count);
	}
	
	static int getTaste(int bits) {
		int sum = 0;
		for(int r = 0; r < N; r++) {
			if((bits & 1<<r) != 0) {
				for(int c = 0; c < N; c++) {
					if((bits & 1<<c) != 0) {
						sum += syn[r][c];
					}
				}
			}
		}
		return sum;
	}
}