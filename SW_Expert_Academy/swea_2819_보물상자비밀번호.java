import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_2819_보물상자비밀번호 {	
	static String list[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			list = new String[N];
			int len = N / 4;
			
			String str = br.readLine();
			str = str + str.substring(0, len);
			
			for(int i = 0; i < N; i++) {
				list[i] = str.substring(0+i, len+i);
			}
			
			Arrays.sort(list, (s1, s2)->s2.compareTo(s1));
						
			int count = 0;
			String prev = " ";
			for(int i = 0; i < N; i++) {
				if(list[i].compareTo(prev) == 0) continue;
				prev = list[i];
				
				if(++count != K) continue;
				
				long sum = Long.parseLong(list[i], 16);
				sb.append(sum).append('\n');
				break;
			}
			
		}
		System.out.println(sb);
	}
}
