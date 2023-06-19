#include<iostream>
#include<vector>
#include<cstring>
#include<algorithm>
#include<string>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		string st;
		cin >> st;
		int cnt = 0;
		bool cur = false;
		for (int i = 0; i < st.size(); i++) {
			if (cur!=st[i]-'0') {
				cnt++;
				cur = !cur;
			}
		}
		cout << "#" << test_case << " " << cnt << "\n";
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}