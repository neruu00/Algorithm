import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K개_중에_1개를_N번_뽑기 {
	static StringBuilder sb = new StringBuilder();
	static int arr[];
	static int N, K;
	
	static void perm(int depth) {
		if(depth == K) {
			for(int n : arr) {
				sb.append(n).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			arr[depth] = i;
			perm(depth + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		
		perm(0);
		
		System.out.println(sb);
	}
}
