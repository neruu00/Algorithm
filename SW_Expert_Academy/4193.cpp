#include <iostream>
#include <queue>

using namespace std;

#define INF 2147483647

struct State
{
    int r, c, time;

    bool operator>(const State &other) const
    {
        return time > other.time;
    }
};

int N;
int sea[15][15];
int dist[15][15];
int dr[] = {-1, 1, 0, 0};
int dc[] = {0, 0, -1, 1};

int solve()
{
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cin >> sea[i][j];
            dist[i][j] = INF;
        }
    }

    int sr, sc, er, ec;
    cin >> sr >> sc >> er >> ec;

    priority_queue<State, vector<State>, greater<State>> pq;

    dist[sr][sc] = 0;
    pq.push({sr, sc, 0});

    while (!pq.empty())
    {
        State curr = pq.top();
        pq.pop();

        if (curr.time > dist[curr.r][curr.c])
            continue;

        if (curr.r == er && curr.c == ec)
        {
            return curr.time;
        }

        for (int i = 0; i < 4; i++)
        {
            int nr = curr.r + dr[i];
            int nc = curr.c + dc[i];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || sea[nr][nc] == 1)
            {
                continue;
            }

            int next_time = curr.time + 1;

            if (sea[nr][nc] == 2)
            {
                int wait = (2 - (curr.time % 3) + 3) % 3;
                next_time = curr.time + wait + 1;
            }

            if (next_time < dist[nr][nc])
            {
                dist[nr][nc] = next_time;
                pq.push({nr, nc, next_time});
            }
        }
    }

    return -1; // 도달 불가능
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    for (int tc = 1; tc <= T; tc++)
    {
        cout << "#" << tc << " " << solve() << "\n";
    }
    return 0;
}