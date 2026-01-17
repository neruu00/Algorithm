#include <iostream>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int T;

    cin >> T;

    for (int test_case = 1; test_case <= T; ++test_case)
    {
        int N;
        cin >> N;
        int arr[7][7];

        for (int y = 0; y < N; ++y)
        {
            for (int x = 0; x < N; ++x)
            {
                cin >> arr[y][x];
            }
        }

        cout << '#' << test_case << '\n';
        for (int y = 0; y < N; ++y)
        {
            for (int x = 0; x < N; ++x)
            {
                cout << arr[N - 1 - x][y];
            }
            cout << ' ';
            for (int x = 0; x < N; ++x)
            {
                cout << arr[N - 1 - y][N - 1 - x];
            }
            cout << ' ';
            for (int x = 0; x < N; ++x)
            {
                cout << arr[x][N - 1 - y];
            }
            cout << '\n';
        }
    }

    return 0;
}