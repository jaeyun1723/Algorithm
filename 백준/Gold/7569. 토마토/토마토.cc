#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
#include<deque>
using namespace std;

int N, M, H;
int dx[6] = { -1, 1, 0, 0, 0, 0 };
int dy[6] = { 0, 0, -1, 1, 0, 0 };
int dz[6] = { 0, 0, 0, 0, -1, 1 };
int arr[101][101][101];
int checked[101][101][101];

void bfs() {
	queue<pair<pair<int, int>, int> > q;
	for (int h = 1; h <= H; h++) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (arr[i][j][h] == 1) {
					q.push(make_pair(make_pair(i, j), h));
					checked[i][j][h] = arr[i][j][h];
				}
				else if (arr[i][j][h] == -1) {
					checked[i][j][h] = -1;
					continue;
				}
			}
		}
	}

	while (!q.empty())
	{
		int tx = q.front().first.first;
		int ty = q.front().first.second;
		int tz = q.front().second;

		for (int i = 0; i < 6; i++)
		{
			int nx = tx + dx[i];
			int ny = ty + dy[i];
			int nz = tz + dz[i];

			if (nx < 1 || nx > N || ny < 1 || ny > M || nz < 1 || nz > H) continue;

			if (arr[nx][ny][nz] == 0 && checked[nx][ny][nz] == 0) 
			{
				q.push(make_pair(make_pair(nx, ny), nz));
				checked[nx][ny][nz] = checked[tx][ty][tz] + 1;
			}
		}
		q.pop();
	}
}

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> M >> N >> H;
	for (int h = 1; h <= H; h++) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				cin >> arr[i][j][h];
			}
		}
	}

	bfs();

	int max = 0;
	for (int h = 1; h <= H; h++) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (checked[i][j][h] == 0) 
				{
					cout << -1;
					return 0;
				}

				if (checked[i][j][h] > max) max = checked[i][j][h];
			}
		}
	}
	cout << max - 1;
}