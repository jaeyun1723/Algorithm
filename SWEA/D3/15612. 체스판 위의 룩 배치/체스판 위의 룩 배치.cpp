#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	char chess[8][8];
	for (test_case = 1; test_case <= T; ++test_case)
	{
		vector<pair<int, int>>chk;
		bool flag = false;
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				cin >> chess[i][j];
				if (chess[i][j] == 'O')
					chk.push_back({ i,j });
			}
		if (chk.size() != 8) cout << "#" << test_case << " " << "no" << '\n';
		else
		{
			for (int i = 0; i < chk.size(); i++) {
				int row = chk[i].first;
				int col = chk[i].second;
				for (int a = 0; a < 8; a++) {
					if ((chess[row][a] == 'O' && a != col) || (chess[a][col] == 'O' && a != row)) {
						cout << "#" << test_case << " " << "no" << '\n';
						flag = true;
						break;
					}
				}
				if (flag) break;
			}
			if (!flag) cout << "#" << test_case << " " << "yes" << '\n';
		}


	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}