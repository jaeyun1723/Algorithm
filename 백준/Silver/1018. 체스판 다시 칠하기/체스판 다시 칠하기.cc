#include<iostream>
#include<string>
#include<vector>
#include<cmath>
using namespace std;

vector< vector<char> > v;

int WhiteFirst(int x, int y)	// W가 처음일때
{
	int cnt = 0;
	for (int i = x; i < x + 8; i++)
	{
		for (int j = y; j < y + 8; j++)
		{
			if (i % 2 == 0)
			{
				if (j % 2 == 0 && v[i][j] == 'B')cnt++;
				if (j % 2 == 1 && v[i][j] == 'W')cnt++;
			}
			else
			{
				if (j % 2 == 0 && v[i][j] == 'W')cnt++;
				if (j % 2 == 1 && v[i][j] == 'B')cnt++;
			}
		}
	}
	return cnt;
}
int BlackFirst(int x, int y)	// B가 처음일때
{
	int cnt = 0;
	for (int i = x; i < x + 8; i++)
	{
		for (int j = y; j < y + 8; j++)
		{
			if (i % 2 == 0)
			{
				if (j % 2 == 0 && v[i][j] == 'W')cnt++;
				if (j % 2 == 1 && v[i][j] == 'B')cnt++;
			}
			else
			{
				if (j % 2 == 0 && v[i][j] == 'B')cnt++;
				if (j % 2 == 1 && v[i][j] == 'W')cnt++;
			}
		}
	}
	return cnt;
}
int main() 
{
	int N, M;
	cin >> N >> M;
	v.assign(N, vector<char>(M));
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			char k;
			cin >> k;
			v[i][j] = k;
		}
	}
	int min = 999999;
	for (int i = 0; i <= N - 8; i++)
	{
		for (int j = 0; j <= M - 8; j++)
		{
			int a = WhiteFirst(i, j);
			int b = BlackFirst(i, j);
			min = (int)fmin(min, (int)fmin(a, b));
		}
	}
	cout << min << '\n';
}
