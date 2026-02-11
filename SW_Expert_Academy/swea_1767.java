import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_1767 {
	static int N, totalCount, totalLenght;
	static List<Core> list;
	
	static class Core {
		int r, c, d;
		Core(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < N; c++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp == 1) {
						list.add(new Core(r, c));
					}
				}
			}
		}
	}
	
	static void dfs() {
		
	}
}
