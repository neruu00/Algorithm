import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_24877 {
	static StringBuilder sb = new StringBuilder();
	static int N, L, ans;
	static int numbers[];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			numbers = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = -1;
			dfs(1, 0, 0);
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int result, int depth, int count) {
		if(result > L) return;
		if(count > 0) {
			if(result > ans) ans = result;
		}
		if(depth == N) return;
		
		
		dfs(result * numbers[depth], depth+1, count+1);
		dfs(result, depth+1, count);
	}
}
