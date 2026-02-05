import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_923 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+2][N+2];
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			map[r][c] = 1;
			int cnt = 0;
			for(int d = 0; d < 4; d++) {
				if(map[r+dr[d]][c+dc[d]] == 1) cnt++;
			}
			
			sb.append(cnt >= 3 ? 1 : 0).append('\n');
		}
		System.out.println(sb);
	}
}
