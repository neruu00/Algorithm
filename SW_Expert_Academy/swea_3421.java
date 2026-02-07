import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3421 {
	static int[] checks;
	static int N, M, ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			
			checks = new int[N+1];
						
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				checks[a] = checks[a] | 1 << b;
				checks[b] = checks[b] | 1 << a;
			}
			
			ans = 0;
			subset(1, 0);
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void subset(int idx, int bits) {
		if(idx > N) {
			ans++;
			return;
		}
		
		if((bits & checks[idx]) == 0) {
			subset(idx+1, bits | 1 << idx);
		}
		subset(idx+1, bits);
	}
}
