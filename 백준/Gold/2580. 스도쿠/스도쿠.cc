#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
using namespace std;

int v[9][9];
bool finish;
bool row[9][10];
bool col[9][10];
bool mat[9][10];
vector< pair<int, int> > list;

bool check(int xidx, int yidx, int num)	// num를 넣었을 때 스토쿠 규칙에 맞는 지 검사
{
	if (row[xidx][num] == false && col[yidx][num] == false && mat[3 * (xidx / 3) + (yidx / 3)][num] == false)
		return true;
	else
		return false;
}

void sudoku(int cnt)	// 스토쿠 0에 넣을 숫자 결정
{						// cnt는 list의 인덱스, list의 인덱스에는 빈칸의 인덱스가 들어가 있다.
	if (cnt == list.size() && finish == false)	// 빈칸 없을 시 출력
	{
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				cout << v[i][j] << " ";
			}
			cout << '\n';
		}
		finish = true;
		return;
	}
	for (int i = 1; i < 10 && finish == false; i++)	// 빈칸에 1~10까지 대입 
	{
		if (check(list[cnt].first, list[cnt].second, i))	// 대입 후 확인
		{
			v[list[cnt].first][list[cnt].second] = i;
			row[list[cnt].first][i] = col[list[cnt].second][i] = mat[3 * (list[cnt].first / 3) + (list[cnt].second / 3)][i] = true;

			sudoku(cnt + 1);

			v[list[cnt].first][list[cnt].second] = 0;
			row[list[cnt].first][i] = col[list[cnt].second][i] = mat[3 * (list[cnt].first / 3) + (list[cnt].second / 3)][i] = false;
		}
	}
}
int main() {

	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			int num;
			cin >> num;
			v[i][j] = num;
			if (v[i][j] == 0)
				list.push_back(make_pair(i, j));
			else
			{
				row[i][v[i][j]] = true;
				col[j][v[i][j]] = true;
				mat[3 * (i / 3) + (j / 3)][v[i][j]] = true;
			}
		}
	}

	sudoku(0);
	return 0;
}