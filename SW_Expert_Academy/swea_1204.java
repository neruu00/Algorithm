import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1204 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int tc = Integer.parseInt(br.readLine());
			byte [] cnt = new byte[101];
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				cnt[Integer.parseInt(st.nextToken())]++;
			}
			int idx = 0;
			int max = 0;
			for(int j = 0; j < 101; j++) {
				if(cnt[j] >= max) {
					max = cnt[j];
					idx = j;
				}
			}
			System.out.println("#"+tc+" "+idx);
		}
	}
}
