#include<iostream>
#include<string>
#include<vector>
#include<algorithm>

using namespace std;

string num;
int ans, chg;


int maxNum(int idx) {
	int max_num = 0;
	for (int i = idx; i < num.size(); i++)
		if (num[i] > max_num) max_num = num[i];
	return max_num;
}

void dfs(int idx, int cnt) {
	if (cnt == chg)
	{
		ans = max(ans, stoi(num));
		return;
	}
	for (int i = idx; i < num.size() - 1; i++)
	{
		int max_num = maxNum(i + 1);
		for (int j = i + 1; j < num.size(); j++)
		{
			if (max_num == num[j]) {	// 최댓값이 같은 경우 여러 개
				swap(num[i], num[j]);
				dfs(i, cnt + 1);
				swap(num[i], num[j]);
			}
		}
	}
}

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; test_case++)
	{
		cin >> num >> chg;
		ans = 0;
		dfs(0,0);
			cout << "#" << test_case << " " << ans << "\n";
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
