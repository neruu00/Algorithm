import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_2117_홈방범서비스 {
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static List<Point> homes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            homes = new ArrayList<>();
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    if (st.nextToken().equals("1")) {
                        homes.add(new Point(r, c));
                    }
                }
            }

            int maxHomeCount = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    
                    int distCount[] = new int[N * 2 + 1];
                    for (Point home : homes) {
                        int d = Math.abs(r - home.r) + Math.abs(c - home.c);
                        distCount[d]++;
                    }

                    int currentHomeCount = 0;
                    for (int k = 1; k <= N + 1; k++) {
                        currentHomeCount += distCount[k - 1];

                        int cost = k * k + (k - 1) * (k - 1);
                        int profit = (currentHomeCount * M) - cost;

                        if (profit >= 0) {
                            maxHomeCount = Math.max(maxHomeCount, currentHomeCount);
                        }
                    }
                }
            }

            sb.append('#').append(tc).append(' ').append(maxHomeCount).append('\n');
        }
        System.out.print(sb);
    }
}