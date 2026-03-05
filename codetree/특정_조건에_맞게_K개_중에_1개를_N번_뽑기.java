import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 특정_조건에_맞게_K개_중에_1개를_N번_뽑기 {
	static StringBuilder sb = new StringBuilder();
	static int K, N;
	static int arr[];
	
	static void perm(int depth, int last, int seq) {
		if(depth == N) {
			for(int a: arr) sb.append(a).append(' ');
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i <= K; i++) {
			if(i == last && seq == 2) continue;
			arr[depth] = i;
			perm(depth+1, i, last == i ? seq+1 : 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		perm(0, 0, 0);
		
		System.out.println(sb);
	}
}
