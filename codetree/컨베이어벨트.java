import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트 {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int nums[] = new int[N*2];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	int idx = (i + T) % (N * 2);
        	nums[idx] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	int idx = (N + i + T) % (N * 2);
        	nums[idx] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 0; i < N; i++) {
        	sb.append(nums[i]).append(' ');
        }
        sb.append('\n');
        
        for(int i = 0; i < N; i++) {
        	sb.append(nums[N + i]).append(' ');
        }
        
        System.out.println(sb);
	}
}
