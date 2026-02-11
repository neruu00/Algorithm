import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17070 {
	static int N, map[][], ans;

	static void dfs(int r, int c, int d) {

		// 조건 충족 시
		if (r + 1 == N && c + 1 == N) {
			ans++;
			return;
		}

		// 파이프 오른쪽이 맵 범위 이내고 벽이 아닌지
		boolean isRightEmpty = c + 1 < N && map[r][c + 1] != 1;
		
		// 파이트 아래쪽이 맵 범위 이내고 벽이 아닌지
		boolean isBottomEmpty = r + 1 < N && map[r + 1][c] != 1;

		// 0 : 파이프가 가로로 배치된 경우
		if (d == 0 && isRightEmpty) {
			dfs(r, c + 1, 0);
			if (isBottomEmpty && map[r + 1][c + 1] != 1) {
				dfs(r + 1, c + 1, 2);
			}
		} 
		// 1 : 파이프가 세로로 배치된 경우
		else if (d == 1 && isBottomEmpty) {
			dfs(r + 1, c, 1);
			if (isRightEmpty && map[r + 1][c + 1] != 1) {
				dfs(r + 1, c + 1, 2);				
			}
		// 2 : 파이프가 대각선으로 배치된 경우
		} else if (d == 2) {
			if (isRightEmpty) dfs(r, c + 1, 0);
			if (isBottomEmpty) dfs(r + 1, c, 1);
			if (isRightEmpty && isBottomEmpty && map[r + 1][c + 1] != 1) {
				dfs(r + 1, c + 1, 2);				
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 1, 0);

		System.out.println(ans);
	}

}
