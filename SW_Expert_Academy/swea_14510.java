import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_14510 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
   
	static int[] heights;
	
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            heights = new int[N];
            
            int max = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
            	heights[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, heights[i]);
            }

            int result = Math.min(solve(max), solve(max + 1));

            sb.append("#").append(tc).append(" ").append(result).append('\n');
        }
        System.out.println(sb);
    }

    private static int solve(int target) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int ans = high;

        int s = 0; 
        int sum = 0; 

        for (int h : heights) {
            int diff = target - h;
            s += (diff % 2);
            sum += diff;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int odd = mid - mid / 2;
            int even = mid / 2;

            if (sum <= (odd + even * 2) && s <= odd) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}