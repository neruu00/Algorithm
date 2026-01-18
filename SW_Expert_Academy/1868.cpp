#include <iostream>
#include <queue>
using namespace std;

pair<char, int> arr[300][300];
int dr[] = {-1, 1, 0, 0, -1, -1, 1, 1};
int dc[] = {0, 0, -1, 1, -1, 1, -1, 1};

int solve(int n)
{
    int count = 0;

    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            if (arr[i][j].second == 0)
            {
                queue<pair<int, int>> q;
                q.push({i, j});
                arr[i][j].second = -1;
                count++;

                while (!q.empty())
                {
                    auto [r, c] = q.front();
                    q.pop();

                    for (int d = 0; d < 8; ++d)
                    {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                            continue;

                        if (arr[nr][nc].second == 0)
                            q.push({nr, nc});

                        arr[nr][nc].second = -1;
                    }
                }
            }
        }
    }
    for (int i = 0; i < n; ++i)
    {
        for (int j = 0; j < n; ++j)
        {
            if (arr[i][j].second > 0)
                count++;
        }
    }
    return count;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    // cout.tie(NULL);

    int T;
    cin >> T;

    for (int test_case = 1; test_case <= T; ++test_case)
    {
        int N;
        cin >> N;

        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                cin >> arr[i][j].first;
                arr[i][j].second = 0;
            }
        }

        for (int i = 0; i < N; ++i)
        {
            for (int j = 0; j < N; ++j)
            {
                if (arr[i][j].first == '*')
                {
                    arr[i][j].second = -1;
                    continue;
                }

                for (int d = 0; d < 8; ++d)
                {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                        continue;

                    if (arr[nr][nc].first == '*')
                        arr[i][j].second++;
                }
            }
        }

        cout << "#" << test_case << " " << solve(N) << "\n";
    }
}