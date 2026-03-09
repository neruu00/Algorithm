import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class swea_1868 {
	static int N;
	static char map[][];
	static int sumMap[][]; // 0 : boom, 1 : empty, 2 : boom neighbour 
	static int dr[] = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int dc[] = {0, 0, -1, 1, -1, 1, -1, 1};
	
	static void bfs(int r, int c) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {r, c});
		sumMap[r][c] = 0;
		
		while(!queue.isEmpty()) {
			int[] p = queue.poll();
			
			for(int d = 0; d < 8; d++) {
				int nr = p[0] + dr[d];
				int nc = p[1] + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				
				int curr = sumMap[nr][nc];
				
				if(curr == 0) continue;

				sumMap[nr][nc] = 0;
				
				if(curr == 1) queue.offer(new int[] {nr, nc});
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new char[N][N];
			sumMap = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				String str =  br.readLine();
				map[r] = str.toCharArray();
			}
			
			for(int r = 0; r < N; r++) {
				A : for(int c = 0; c < N; c++) {
					if(map[r][c] == '*') continue;
					
					for(int d = 0; d < 8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
						
						if(map[nr][nc] == '*') {
							sumMap[r][c] = 2;
							continue A;
						}
					}
					sumMap[r][c] = 1;
				}
			}
			
			int ans = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(sumMap[r][c] != 1) continue;
					ans++;
					bfs(r, c);
				}
			}
			
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(sumMap[r][c] == 2) ans++;
				}
			}
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
