#include<iostream>
#include<vector>
#include<cstring>
#include<algorithm>
#include<string>
using namespace std;

vector<vector<int>> v;
vector<bool> visited;
int N, M, res;

void dfs(int start, int cnt) {
	if (cnt == N) {
		res = cnt;
		return;
	}
	for (int i = 1; i <= N; i++)
	{
		if (v[start][i] == 1 && !visited[i])
		{
			visited[i] = true;
			dfs(i, cnt + 1);
			visited[i] = false;
		}
	}
	if (cnt > res) res = cnt;
}

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> N >> M;
		v.assign(N + 1, vector<int>(N + 1, 0));
		visited.assign(N, false);
		for (int i = 0; i < M; i++) {
			int x, y;
			cin >> x >> y;
			v[x][y] = 1;
			v[y][x] = 1;
		}
		res = 0;
		for (int i = 1; i <= N; i++)
		{
			visited.assign(N + 1, false);
			visited[i] = true;
			dfs(i, 1);
		}

		cout << "#" << test_case << " " << res << "\n";
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}