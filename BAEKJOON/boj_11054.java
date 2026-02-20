import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11054 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp_inc = new int[N];
        int[] dp_dec = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp_inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp_inc[i] = Math.max(dp_inc[i], dp_inc[j] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            dp_dec[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    dp_dec[i] = Math.max(dp_dec[i], dp_dec[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp_inc[i] + dp_dec[i] - 1);
        }

        System.out.println(ans);
    }
}