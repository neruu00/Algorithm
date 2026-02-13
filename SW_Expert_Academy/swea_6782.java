import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_6782 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			int count = 0;
			
			
			while(N != 2) {
				double tmp = Math.sqrt(N);
				if(tmp % 1 != 0) {
					long next = (long)Math.pow((int)tmp+1, 2);
					long diff = next - N;
					count += diff;
					N = next;
				}
				else {
					N = (long)tmp;
					count++;
				}
			}
			
			sb.append('#').append(tc).append(' ').append(count).append('\n');
		}
		
		System.out.println(sb);
	}
}
