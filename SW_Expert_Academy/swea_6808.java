import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class swea_6808 {
    static int win = 0, lose = 0;
    static int[] kCards = new int[9];
    static int[] iCards = new int[9];
    static int[] dp = new int[10];
 
    static int fact(int n) {
        if (n <= 1) return 1;
        if (dp[n] > 0)
            return dp[n];
        return dp[n] = n * fact(n - 1);
    }
 
    static void dfs(int depth, int kScore, int iScore, int bit) {
        if (kScore > 85) {
            win += fact(9-depth);
            return;
        }
        else if (iScore > 85) {
            lose += fact(9-depth);
            return;
        }
 
        for (int i = 0; i < 9; i++) {
            if ((bit & (1 << i)) == 0) {
                int kc = kCards[depth];
                int ic = iCards[i];
 
                int nextKScore = kc > ic ? kScore + kc + ic : kScore;
                int nextIScore = ic > kc ? iScore + kc + ic : iScore;
 
                dfs(depth + 1, nextKScore, nextIScore, bit | (1 << i));
            }
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= T; tc++) {
            win = lose = 0;
            boolean[] isKCard = new boolean[19];
 
            st = new StringTokenizer(br.readLine());
 
            for (int i = 0; i < 9; i++) {
                kCards[i] = Integer.parseInt(st.nextToken());
                isKCard[kCards[i]] = true;
            }
 
            int idx = 0;
            for (int i = 1; i <= 18; i++) {
                if (isKCard[i] == false)
                    iCards[idx++] = i;
            }
 
            dfs(0, 0, 0, 0);
 
            sb.append("#").append(tc).append(' ').append(win).append(' ').append(lose).append('\n');
 
        }
        System.out.println(sb);
    }
}