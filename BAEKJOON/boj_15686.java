import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_15686 {
	static int N, M, ans = Integer.MAX_VALUE;
	static List<Pos> homes = new ArrayList<>();
	static List<Pos> chicks = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		for(int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				int p = Integer.parseInt(st.nextToken());
				if(p == 1) homes.add(new Pos(r, c));
				else if(p == 2) chicks.add(new Pos(r, c));
			}
		}		
		
		dfs(0, 0, 0);
		System.out.println(ans);
	}
	
	static class Pos {
		int r, c;
		Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static void dfs(int bits, int count, int start) {
		if(count == M) {
			int sum = 0;
			for(Pos home : homes) {
				int min = Integer.MAX_VALUE;
				for(int i = 0; i < chicks.size(); i++) { 
					if((bits & 1<<i) == 0) continue;
					Pos chick = chicks.get(i);
					int dist = Math.abs(home.r - chick.r) + Math.abs(home.c - chick.c);
					min = Math.min(min, dist);
				}
				sum+=min;
			}
			ans=Math.min(ans, sum);
		}
		
		for(int i = start; i < chicks.size(); i++) {
			dfs(bits | 1<<i, count+1, i+1);
		}
	}
}
