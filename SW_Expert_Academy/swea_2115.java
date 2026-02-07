import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2115 {
	static int N, M, C;
	static int map[][], maxMap[][];
	static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			maxMap = new int[N][N-M+1];
			
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c <= N-M; c++) {
					subset(r, c, 0, 0, 0);
				}
			}
			
			ans = -1;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N-M+1; c++) {
					for(int y = r; y < N; y++) {
						int start = (y == r) ? c+M : 0;
						for(int x = start; x < N-M+1; x++) {
							int sum = maxMap[r][c] + maxMap[y][x];
							if(sum > ans) ans = sum;
						}
					}
				}
			}
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void subset(int i, int j, int cnt, int sum, int powSum) {
		if(sum > C) return;
		if(cnt == M) {
			if(powSum > maxMap[i][j-M]) maxMap[i][j-M] = powSum;
			return;
		}
		
		subset(i, j+1, cnt+1, sum+map[i][j], powSum+map[i][j]*map[i][j]);
		subset(i, j+1, cnt+1, sum, powSum);
	}
}
