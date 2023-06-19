#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include<cstring>
using namespace std;

vector<int> pep;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int N, M, K;	// N명, M초, K개
		cin >> N >> M >> K;
		pep.assign(N, 0);
		for (int i = 0; i < N; i++)
			cin >> pep[i];
		sort(pep.begin(), pep.end());
		bool flag = false;
		for (int i = 0; i < N; i++)
		{
			int Q = pep[i] / M;
			int made = Q * K;
			if (made < i + 1) {
				flag = true;
				break;
			}
		}
		if (flag) cout << "#" << test_case << " Impossible" << "\n";
		else cout << "#" << test_case << " Possible" << "\n";

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}