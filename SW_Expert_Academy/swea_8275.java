import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백트래킹을 활용해 가능한 모든 해를 탐색 후
 * 최적해를 답으로 선택
 * 
 * 유효성 검사는 r을 탐색 할 때 진행
 * 
 * 가지치기 조건
 * 1. 현재 최적해보다 나은 최적해가 나오지 않는 경우
 * 2. 현재 depth까지의 탐색 결과가 유효하지 않은 경우
 */

public class swea_8275 {
	static int cages[], ans[];
	static List<int[]>[] checks;
	static int N, X, M, max;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			cages = new int[N+1];
			ans = new int[N+1];
			checks = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) checks[i] = new ArrayList<>();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int l = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				checks[r].add(new int[] {l, s});
			}
			
			max = -1;
			dfs(1, 0);
			
			sb.append('#').append(tc).append(' ');
			if(max < 0)	sb.append(-1);
			else {
				for(int i = 1; i <= N; i++) {
					sb.append(ans[i]).append(' ');
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void dfs(int idx, int sum) {
		if (max != -1 && sum + (N - idx + 1) * X < max) {
            return;
        }
		
		if(idx > N) {
			if(sum > max) {
				for(int i = 1; i <= N; i++) ans[i] = cages[i];
				max = sum;
			}
			return;
		}
		
		for(int i = 0; i <= X; i++) {
			cages[idx] = i;
			if(validate(idx)) {
				dfs(idx+1, sum+cages[idx]);
			}
		}
	}
	
	static boolean validate(int r) {
		for(int[] check : checks[r]) {
			int sum = 0;
			for(int i = check[0]; i <= r; i++) {
				sum += cages[i];
			}
			if(sum != check[1]) return false;
		}
		return true;
	}
}
