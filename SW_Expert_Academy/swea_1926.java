import java.io.BufferedReader;
import java.io.InputStreamReader;

public class swea_1926 {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int N = Integer.parseInt(br.readLine());
         
        for(int n = 1; n <= N; n++) {
            int cnt = 0;
            int tmp = n;
            while(tmp > 0) {
                int digit = tmp % 10;
                if(digit == 3 || digit == 6 || digit == 9) cnt++;
                tmp /= 10;
            }
            if(cnt == 0) {
                sb.append(n);
            } else {
                for(int i = 0; i < cnt; i++) sb.append('-');
            }
            sb.append(' ');
        }
        System.out.println(sb);
    }
}
