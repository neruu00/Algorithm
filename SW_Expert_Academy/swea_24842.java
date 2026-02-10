import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_24842 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
		dfs(0, 0);
		
		System.out.println(sb);
	}
	
	static void dfs(int result, int depth) {
		if(depth == 3) {
			sb.append(result).append('\n');
			return;
		}
		
		for(int i = 1; i <= 6; i++) {
			dfs(result * 10 + i, depth+1);
		}
	}
}

