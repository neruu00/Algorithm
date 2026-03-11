import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_30805 {
	static int N, M;
	static int aList[], bList[], result[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		aList = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			 aList[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		bList = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			bList[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new int[N];
		
		int count = 0;
				
		for(int i = 0; i < N; i++) {
			
			int next = count;
			for(int j = 0; j < count; j++) {
				if(bList[result[j]] < aList[i]) {
					next = j;
					break;
				}
			}
			
			for(int j = next > 0 ? result[next-1]+1 : 0; j < M; j++) {
				if(aList[i] != bList[j]) continue;
				count = next;				
				result[count++] = j;
				break;
			}
		}
		
		sb.append(count).append('\n');
		for(int i = 0; i < count; i++) sb.append(bList[result[i]]).append(' ');
		
		System.out.println(sb);
	}
}
