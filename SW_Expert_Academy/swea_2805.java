import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_2805 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int dist, cr, cc;
			dist = cr = cc = N/2;
			
			int map[][] = new int[N][N];
			for(int r = 0; r < N; r++) {
				char[] str = br.readLine().toCharArray();
				for(int c = 0; c < N; c++) {
					map[r][c] = str[c] - '0';
				}
			}
			
			int sum = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(Math.abs(cr-r)+Math.abs(cc-c) <= dist) {
						sum+=map[r][c];
					}
				}
			}
			
			sb.append('#').append(tc).append(' ').append(sum).append('\n');
		}
		System.out.println(sb);
	}
}
