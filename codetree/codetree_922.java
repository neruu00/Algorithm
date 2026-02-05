import java.io.BufferedReader;
import java.io.InputStreamReader;

public class codetree_922 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int r = 0, c = 0;
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		int d = 0;
		int ans = 0;
		
		for(char cmd : str) {
			ans++;
			if(cmd == 'F') {
				r += dr[d];
				c += dc[d];
				if(r == 0 && c == 0) {
					System.out.println(ans);
					System.exit(0);
				}
			} else if(cmd == 'R') {
				d = (d + 1) % 4;
			} else {
				d = (d - 1 + 4) % 4;
			}
			
		}
		System.out.println(-1);
	}
}
