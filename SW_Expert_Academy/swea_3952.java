import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_3952 {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static boolean used[];
	static List<Integer> list[];
	
	static void simulate() {
		int count = 0;
		
		while(count != N) {
			 A : for(int i = 1; i <= N; i++) {
				if(used[i]) continue;
				for(int n : list[i]) {
					if(!used[n]) continue A;
				}
				used[i] = true;
				count++;
				sb.append(i).append(' ');
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			used = new boolean[N+1];
			list = new List[N+1];
			for(int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[b].add(a);
			}
			
			sb.append('#').append(tc).append(' ');
			simulate();
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
