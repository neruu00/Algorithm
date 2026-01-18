#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, B;
int heights[20];
int min_diff;

void dfs(int idx, int sum)
{
    if (sum >= B)
    {
        min_diff = min(min_diff, sum - B);
        return;
    }

    if (idx == N)
    {
        return;
    }

    dfs(idx + 1, sum + heights[idx]);

    dfs(idx + 1, sum);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    for (int t = 1; t <= T; ++t)
    {
        cin >> N >> B;

        for (int i = 0; i < N; ++i)
        {
            cin >> heights[i];
        }

        min_diff = 200001;

        dfs(0, 0);

        cout << "#" << t << " " << min_diff << "\n";
    }

    return 0;
}