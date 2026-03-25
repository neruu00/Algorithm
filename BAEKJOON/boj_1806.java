import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        
        // 탐색 시작
        while (true) {
            // 합이 S 이상인 경우: 조건을 만족하므로 길이를 갱신하고 left를 이동시켜 구간을 좁힘
            if (sum >= S) {
                minLength = Math.min(minLength, right - left);
                sum -= arr[left];
                left++;
            } 
            // right가 배열의 끝에 도달한 경우: 더 이상 구간을 넓힐 수 없으므로 종료
            else if (right == N) {
                break;
            } 
            // 합이 S 미만인 경우: 조건을 만족하지 못하므로 right를 이동시켜 구간을 넓힘
            else {
                sum += arr[right];
                right++;
            }
        }
        
        System.out.println(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}