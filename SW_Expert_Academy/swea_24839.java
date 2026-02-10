import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_24839 {
	static StringBuilder sb = new StringBuilder();
	static int nums[];
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			nums = new int[N];

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			sb.append('#').append(tc).append('\n');
			dfs(0, 0, 0, 0);
		}
		System.out.println(sb);
	}

	static void dfs(int result, int depth, int count, int visited) {
		if(count == M) {
			sb.append(result).append('\n');
			return;
		}
		if (depth == N) return;

		for(int i = 0; i < N; i++) {
			if((visited & 1 << i) == 0) {
				dfs(result * 10 + nums[i], depth + 1, count + 1, visited | 1 << i);
			}
		}
	}
}
