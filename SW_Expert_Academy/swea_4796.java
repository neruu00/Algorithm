import java.io.IOException;
import java.io.StreamTokenizer;

public class swea_4796 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		StreamTokenizer st;
	
		st = new StreamTokenizer(System.in);
		st.nextToken();
		int T = (int)st.nval;
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StreamTokenizer(System.in);
			st.nextToken();
			int N = (int)st.nval;
			int arr[] = new int[N];
			
			st = new StreamTokenizer(System.in);
			for(int n = 0; n < N; n++) {
				st.nextToken();
				arr[n] = (int)st.nval;
			}
			
			int i = 0, j = 0, k, sum = 0;
			while(true) {
				if(i + 2 > N) break;
				if(arr[i] > arr[i+1]) {
					i++;
					continue;
				}
				
				k = i + 1;
				
				while((k+1 < N) && (arr[k] < arr[k+1])) {
					k++;
				}
				
				j = k;
				
				while((j+1 < N) && (arr[j] > arr[j+1])) {
					j++;
				}
				
				sum += (k - i) * (j - k);
				i = j;	
			}
			
			sb.append('#').append(tc).append(' ').append(sum).append('\n');
		}
		System.out.println(sb);
	}
}
