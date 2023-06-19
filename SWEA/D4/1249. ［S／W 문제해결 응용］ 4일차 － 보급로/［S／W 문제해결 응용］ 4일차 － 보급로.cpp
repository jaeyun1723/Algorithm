#include<iostream>
#include<string>
#include<vector>
#include<cstring>
#include<queue>

using namespace std;

//vector<vector<int>>v;
//vector<vector<int>>dp;
//vector<vector<bool>>visited;
queue<pair<int, int>> q;
int x[] = { 0,0,1,-1 };
int y[] = { 1,-1,0,0 };
int v[100][100];
int dp[100][100];
bool visited[100][100];
int N;
//int x[4] = {1,-1,0,0};
//int y[4] = {0,0,-1,1};
//int N;

void BFS(int i, int j) {
	q.push(make_pair(i,j));	
	visited[i][j] = true;
	while (!q.empty()) {
		int idx1 = q.front().first;	// 현 위치
		int idx2 = q.front().second;
		for (int k = 0; k < 4; k++) {
			int row = idx1 + x[k];	// 갈 위치
			int col = idx2 + y[k];
			if (row >= 0 && col >= 0 && row < N && col < N)
			{
				if (!visited[row][col] || dp[row][col] > dp[idx1][idx2] + v[row][col])
				{
					visited[row][col] = true;
					dp[row][col] = dp[idx1][idx2] + v[row][col];
					q.push(make_pair(row, col));
				}
			}
		}
		q.pop();
	}
}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> N;
		memset(v, 0, sizeof(v));
		memset(dp, 0, sizeof(dp));
		memset(visited, false, sizeof(visited));
		/*v.resize(N, vector<int>(N, 0));
		dp.resize(N, vector<int>(N, 0));
		visited.resize(N, vector<bool>(N, false));*/
		for (int i = 0; i < N; i++) {
			string s;
			cin >> s;
			for (int j = 0; j < N; j++)
				v[i][j] = s[j] - '0';
		}
		BFS(0, 0);
		cout << "#" << test_case << " " << dp[N - 1][N - 1] << '\n';
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}