#include<iostream>
#include<cstring>
#include<algorithm>
#include<string>
#include<vector>
#include<set>

using namespace std;

char v[4][4];
set<string> st;
int mx[4] = { 1,-1,0,0 };
int my[4] = { 0,0,1,-1 };
void dfs(int r_idx, int c_idx, int len, string str) {
	if (len == 7) {
		st.insert(str);
		return;
	}
	str += v[r_idx][c_idx];
	for (int i = 0; i < 4; i++) {
		int x = r_idx + mx[i];
		int y = c_idx + my[i];
		if (x < 0 || x >= 4 || y < 0 || y >= 4) continue;
		dfs(x, y, len + 1, str);
	}

}

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin >> T;
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		st.clear();
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				cin >> v[i][j];

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				dfs(i, j, 0, "");

		cout << "#" << test_case << " " << st.size() << "\n";
	

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}