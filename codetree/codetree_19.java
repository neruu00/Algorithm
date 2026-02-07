import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class codetree_19 {
    static int N, M;
    static List<int[]> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 
        map = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    map.add(new int[]{i, j});
                }
            }
        }

        int ans = 0;

        for (int K = 0; K <= N + 1; K++) {
            int cost = K * K + (K + 1) * (K + 1);

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    int gold = 0;

                    for (int[] p : map) {
                        int dist = Math.abs(r - p[0]) + Math.abs(c - p[1]);
                        
                        if (dist <= K) {
                        	gold++;
                        }
                    }

                    if (gold * M >= cost) {
                    	ans = Math.max(ans, gold);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}