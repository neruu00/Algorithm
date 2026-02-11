import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1987 {
	static int R, C, ans;
	static char map[][];
	
	static void dfs(int r, int c, int count, int visited) {
		if((visited & 1<<map[r][c]-'A') != 0) {
			ans = Math.max(ans, count);
			return;
		}
		
		int nextVisited = visited | 1<<map[r][c]-'A';
		
		if(r > 0) dfs(r-1, c, count+1, nextVisited);
		if(r+1 < R) dfs(r+1, c, count+1, nextVisited);
		if(c > 0) dfs(c-1, c, count+1, nextVisited);
		if(c+1 < C) dfs(c+1, c, count+1, nextVisited);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		dfs(0, 0, 1, 0);
		
		System.out.println(ans);
	}
}
