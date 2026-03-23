import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2342 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<Integer> moves = new ArrayList<>();
        while (true) {
            int move = Integer.parseInt(st.nextToken());
            if (move == 0) break;
            moves.add(move);
        }
        
        int n = moves.size();
        if (n == 0) {
            System.out.println(0);
            return;
        }
        
        // dp[i][l][r] = i번째 스텝까지, 왼발 l, 오른발 r 위치일 때의 최소 힘
        int[][][] dp = new int[n + 1][5][5];
        
        // 최솟값을 구해야 하므로 초기값은 아주 큰 값으로 설정
        int INF = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            for (int l = 0; l < 5; l++) {
                Arrays.fill(dp[i][l], INF);
            }
        }
        
        // 0번째 스텝, 두 발 모두 0 위치에서 시작. 드는 힘은 0
        dp[0][0][0] = 0;
        
        // i: 진행 중인 스텝의 인덱스 (0부터 시작)
        for (int i = 0; i < n; i++) {
            int target = moves.get(i);
            
            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    // 도달할 수 없는 상태(초기값)면 건너뜀
                    if (dp[i][l][r] == INF) continue;
                    
                    // 1. 왼발을 target으로 움직이는 경우 (단, 오른발과 겹치지 않게)
                    if (target != r) {
                        dp[i + 1][target][r] = Math.min(dp[i + 1][target][r], dp[i][l][r] + getCost(l, target));
                    }
                    
                    // 2. 오른발을 target으로 움직이는 경우 (단, 왼발과 겹치지 않게)
                    if (target != l) {
                        dp[i + 1][l][target] = Math.min(dp[i + 1][l][target], dp[i][l][r] + getCost(r, target));
                    }
                }
            }
        }
        
        // 모든 스텝을 마친 후(n번째), 가능한 모든 발 위치의 경우의 수 중 가장 작은 값 찾기
        int answer = INF;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                answer = Math.min(answer, dp[n][l][r]);
            }
        }
        
        System.out.println(answer);
    }
    
    // 두 지점 사이의 이동 비용을 계산하는 메서드
    static int getCost(int from, int to) {
        if (from == 0) return 2; // 중앙에서 출발
        if (from == to) return 1; // 같은 지점 다시 누름
        if (Math.abs(from - to) == 2) return 4; // 반대편 (1-3, 2-4)
        return 3; // 인접한 지점
    }
}