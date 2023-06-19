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
int N;
vector<vector<int> > v;
vector<vector<bool> > visited;
vector<int> apt;

int dfs(int x, int y)
{
	if (x < 0 || x >= N || y < 0 || y >= N) 
		return 0;
	if (!v[x][y] || visited[x][y])
		return 0;
	else
	{
		visited[x][y] = true;
		return 1 + dfs(x + 1, y) + dfs(x - 1, y) + dfs(x, y - 1) + dfs(x, y + 1);
	}
}

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> N;
	v.resize(N, vector<int>(N));
	visited.resize(N, vector<bool>(N));
	string s;
	int src = 0;

	for (int i = 0; i < N; i++)
	{
		cin >> s;
		for (int j = 0; j < N; j++)
		{
			v[i][j] = s[j] - '0';
		}
	}
	

	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			if (v[i][j] == 1 && visited[i][j] == false)
			{
				src++;
				int cnt = dfs(i, j);
				apt.push_back(cnt);
			}

	sort(apt.begin(), apt.end());
	cout << src << '\n';
	for (int i = 0; i < apt.size(); i++)
		cout << apt[i] << "\n";
}