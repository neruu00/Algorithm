import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 맵방문하기 {
    static char map[][];
    static int N, M;
    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};
    static int visited[][];
    static int visitId = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M];
        
        for(int r = 0; r < N; r++) {
            map[r] = br.readLine().toCharArray();
        }
        
        int ans = solve();

        char[] dirs = {'U', 'R', 'D', 'L'};

        for(int r = 0; r < N; r++) {
            char[] backup = map[r].clone();
            for(char d : dirs) {
                Arrays.fill(map[r], d);
                ans = Math.max(ans, solve());
            }
            map[r] = backup;
        }

        for(int c = 0; c < M; c++) {
            char[] backup = new char[N];
            for(int i = 0; i < N; i++) backup[i] = map[i][c];
            
            for(char d : dirs) {
                for(int i = 0; i < N; i++) map[i][c] = d;
                ans = Math.max(ans, solve());
            }
            for(int i = 0; i < N; i++) map[i][c] = backup[i];
        }

        System.out.println(ans);
    }

    static int solve() {
        int max = 0;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                int res = simulate(r, c);
                if(res > max) max = res;
            }
        }
        return max;
    }

    static int simulate(int r, int c) {
        visitId++;
        int cnt = 0;
        int curR = r, curC = c;

        while(curR >= 0 && curR < N && curC >= 0 && curC < M) {
            if(visited[curR][curC] == visitId) break;
            
            visited[curR][curC] = visitId;
            cnt++;
            
            char ch = map[curR][curC];
            int d = (ch == 'U') ? 0 : (ch == 'R') ? 1 : (ch == 'D') ? 2 : 3;
            
            curR += dr[d];
            curC += dc[d];
        }
        return cnt;
    }
}