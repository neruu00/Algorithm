import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_2112_보호필름 {
	static int D, W, K, ans;
	static boolean mat[][];
	static boolean typeA[];
	static boolean typeB[];
	
	static void comb(int depth, int count) {
		if(count > ans) return;
		
		if(depth == D) {
			A : for(int c = 0; c < W; c++) {
				
				boolean prev = true;
				int seq = 0;
				
				for(int r = 0; r < D; r++) {
					if(prev != mat[r][c]) {
						prev = mat[r][c];
						seq = 0;
					}
					
					if(++seq == K) continue A;
				}
				
				return;
			}
		
			ans = count;
			return;
		}
		
		comb(depth+1, count);
		
		boolean tmp[] = new boolean[W];
		tmp = mat[depth];
		
		mat[depth] = typeA;
		comb(depth+1, count+1);
		
		mat[depth] = typeB;
		comb(depth+1, count+1);
		
		mat[depth] = tmp;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			mat = new boolean[D][W];
			typeA = new boolean[W];
			typeB = new boolean[W];
			
			Arrays.fill(typeA, true);
			
			for(int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < W; c++) {
					mat[r][c] = st.nextToken().charAt(0) == '1';
				}
			}
			
			ans = Integer.MAX_VALUE;
			
			comb(0, 0);
			
			sb.append('#').append(tc).append(' ').append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
