import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_2806 {
	static int N, ans;
	static boolean col[], left[], right[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
			col = new boolean[N];
			left = new boolean[N*2-1];
			right = new boolean[N*2-1];
			dfs(0);
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int depth) {
		if(depth == N) ans++;
		
		for(int i = 0; i < N; i++) {
			if(col[i] || left[depth+i] || right[depth-i+N-1]) continue;
			col[i] = left[depth+i] = right[depth-i+N-1] = true;
			dfs(depth+1);
			col[i] = left[depth+i] = right[depth-i+N-1] = false;
		}
	}
}
