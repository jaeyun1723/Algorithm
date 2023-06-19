#include<iostream>
#include<cstring>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

int mag[100][100];
int cnt;
bool flag;
int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int len;
		cin >> len;
		for (int i = 0; i < len; i++)
			for (int j = 0; j < len; j++)
				cin >> mag[i][j];
	// 1=N, 2=S 위에 N극, 아래에 S극 1은 밑으로, 2는 위로
		flag = false;
		cnt = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (mag[j][i] == 1) flag = true;
				if (flag && mag[j][i] == 2) {
					flag = false;
					cnt++;
				}
			}
			flag = false;
		}
		cout << "#" << test_case << " " << cnt << "\n";
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}