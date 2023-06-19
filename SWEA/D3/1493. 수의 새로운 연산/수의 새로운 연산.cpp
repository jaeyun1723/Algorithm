#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include<cstring>
using namespace std;

int v[301][301];
int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;
	int x, num, sum;
	x = num = sum = 1;
	while (x<=300) {
		sum++;
		x = 1;
		while (x<sum) {
			v[x][sum-x] = num;
			num++;
			x++;
		}
	}
	/*for (int i = 1; i < 6; i++) {
		for (int j = 1; j < 6; j++) {
			cout << v[i][j] << " ";
		}
		cout << '\n';
	}*/
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int p, q;
		cin >> p >> q;
		int x1, x2, y1, y2;
		bool flg1, flg2;
		flg1 = flg2 = false;
		for (int i = 1; i <= 300; i++) {
			for (int j = 1; j <= 300; j++) {
				if (flg1 && flg2) break;
				if (v[i][j] == p)
				{
					x1 = i;
					y1 = j;
					flg1 = true;
				}
				if (v[i][j] == q) {
					x2 = i;
					y2 = j;
					flg2 = true;
				}
			}
			if (flg1 && flg2) break;
		}
		cout << "#" << test_case << " "<<v[x1+x2][y1+y2] << "\n";

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}