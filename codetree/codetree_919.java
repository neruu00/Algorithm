import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_919 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char L = st.nextToken().charAt(0);
		
		int d;
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		if(L == 'U') d = 0;
		else if(L == 'R') d = 1;
		else if(L == 'D') d = 2;
		else d = 3;
		
		for(int i = 0; i < T; i++) {
			int nextR = R + dr[d];
			int nextC = C + dc[d];
			
			if(nextR < 1 || nextR > N || nextC < 1 || nextC > N) {
				d = (d + 2) % 4;
			} else {
				R = nextR;
				C = nextC;
			}
		}
		
		System.out.println(R+" "+C);
	}
}
