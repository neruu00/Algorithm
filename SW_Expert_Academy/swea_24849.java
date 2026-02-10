import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_24849 {
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	static int numbers[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			numbers = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			
			sb.append('#').append(tc).append('\n');
			dfs(0, 0);
		}

		System.out.println(sb);
	}

	static void dfs(int result, int depth) 
	{
		if (depth == K) {
			sb.append(result).append('\n');
			return;
		}

		for (int i = 0; i < N; i++) {
			dfs(result * 10 + numbers[i], depth + 1);
		}
	}
}
