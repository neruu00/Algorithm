import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N개_중에_M개_뽑기 {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int stack[];
	
	static void perm(int depth, int start) {
		if(depth == M) {
			for(int num : stack) {
				sb.append(num).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		int limit =  N - M + depth + 1;
		for(int i = start; i <= limit; i++) {
			stack[depth] = i;
			perm(depth+1, i+1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		stack = new int[M];
		
		perm(0, 1);
		
		System.out.println(sb);
	}
}
