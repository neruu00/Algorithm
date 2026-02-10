import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_24848 {
	static StringBuilder sb = new StringBuilder();
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			sb.append('#').append(tc).append('\n');
			dfs(0, 0);
		}

		System.out.println(sb);
	}

	static void dfs(int result, int depth) {
		if (depth == N) {
			sb.append(result).append('\n');
			return;
		}

		for (int i = 1; i <= 6; i++) {
			dfs(result * 10 + i, depth + 1);
		}
	}
}
