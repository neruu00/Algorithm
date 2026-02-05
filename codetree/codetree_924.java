import java.io.BufferedReader;
import java.io.InputStreamReader;

public class codetree_924 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, -1, 0, 1};
		
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int K = Integer.parseInt(br.readLine());
		int d = (K - 1) / N;
		int r, c, mod = (K - 1) % N;
		if(d == 0) {
			r = 0;
			c = mod;
		} else if(d == 1) {
			r = mod;
			c = N-1;
		} else if(d == 2) {
			r = N-1;
			c = (N - 1) - mod;
		} else {
			r =  (N - 1) - mod;
			c = 0;
		}
		
		int cnt = 0;
		while(true) {
			cnt++;

			if(d == 0) c += dc[d = map[r][c] == '/' ? 1 : 3];
			else if(d == 1) r += dr[d = map[r][c] == '/' ? 0 : 2];
			else if(d == 2) c += dc[d = map[r][c] == '/' ? 3 : 1];
			else r += dr[d = map[r][c] == '/' ? 2 : 0];

			if(r < 0 || r >= N || c < 0 || c >= N) break;
		}
		System.out.println(cnt);
	}
}
	