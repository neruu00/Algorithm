#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    for (int test_case = 1; test_case <= T; ++test_case)
    {
        int N, M;
        int arr[2][20];
        bool flag = false;

        cin >> N >> M;

        for (int i = 0; i < N; ++i)
            cin >> arr[0][i];
        for (int i = 0; i < M; ++i)
            cin >> arr[1][i];

        if (N > M)
            flag = true;

        int sum = 0, max = -987654321;

        for (int i = 0; i <= abs(N - M); ++i)
        {
            sum = 0;
            for (int j = 0; j < min(N, M); ++j)
                sum += arr[int(flag)][j] * arr[int(!flag)][i + j];

            if (sum > max)
                max = sum;
        }
        cout << '#' << test_case << ' ' << max << '\n';
    }

    return 0;
}