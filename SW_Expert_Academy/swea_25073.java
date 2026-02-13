import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_25073 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int N, M, K, X, ans;
	
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());	
			X = N - M;
			
			ans = 0;
			int pair = X * (K - 1);
			if(pair > M) ans = M;
			else {
				int O = M - pair;
				int mul = O / K;
				int mod = O % K;
				for(int i = 0; i < mul; i++) {
					ans += K;
					ans *= 2;
				}
				ans += pair + mod;
			}
			
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}	
}
