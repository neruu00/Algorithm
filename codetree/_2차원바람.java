import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2차원바람 {
	static int N, M, Q;
	static int[][] grid;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		grid = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken()) - 1;
			int c1 = Integer.parseInt(st.nextToken()) - 1;
			int r2 = Integer.parseInt(st.nextToken()) - 1;
			int c2 = Integer.parseInt(st.nextToken()) - 1;

			simulate(r1, c1, r2, c2);
		}
		
		StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
	}
	
	static void simulate(int r1, int c1, int r2, int c2) {
        int tempTopLeft = grid[r1][c1];

        for (int i = r1; i < r2; i++) {
            grid[i][c1] = grid[i + 1][c1];
        }
        for (int j = c1; j < c2; j++) {
            grid[r2][j] = grid[r2][j + 1];
        }
        for (int i = r2; i > r1; i--) {
            grid[i][c2] = grid[i - 1][c2];
        }
        for (int j = c2; j > c1; j--) {
            grid[r1][j] = grid[r1][j - 1];
        }
        grid[r1][c1 + 1] = tempTopLeft;

        int[][] nextGrid = new int[N][M];
        for (int i = 0; i < N; i++) {
            nextGrid[i] = grid[i].clone();
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int sum = grid[i][j];
                int count = 1;

                for (int d = 0; d < 4; d++) {
                    int ni = i + dr[d];
                    int nj = j + dc[d];

                    if (ni >= 0 && ni < N && nj >= 0 && nj < M) {
                        sum += grid[ni][nj];
                        count++;
                    }
                }
                nextGrid[i][j] = sum / count;
            }
        }

        grid = nextGrid;
    }
}
