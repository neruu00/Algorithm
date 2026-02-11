import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_25837 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		A : for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long S = Long.parseLong(st.nextToken());
			long P = Long.parseLong(st.nextToken());

			if(P+1 < S) {
				sb.append("No\n");
				continue;
			}
			
			long min = 1, max = (long) Math.sqrt(P);
			while(min <= max) {
				long mid = (min + max) / 2;
				long mul = (S - mid) * mid;
				if(mul == P) {
					sb.append("Yes\n");
					continue A;
				} else if(mul < P) {
					min = mid + 1;
				} else {
					max = mid - 1;
				}
			}
			
			sb.append("No\n");
		}
		System.out.println(sb);
	}
}
