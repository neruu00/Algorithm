import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_25097 {
	static int list[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append('\n');
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			list = new int[N][N];

			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list[r][c] = Integer.parseInt(st.nextToken());
			}
			
			
			for(int i = 0; i < K; i++) {
				int r = Integer.parseInt(br.readLine());
				
				sb.append(r).append("=[");
				for(int c = 0; c < N; c++) {
					if(list[r][c] != 0) {
						sb.append(c).append(' ').append(list[r][c]).append(',');
					}
				}
				sb.append("]\n");
			}
			
		}
		System.out.println(sb);
	}
}
