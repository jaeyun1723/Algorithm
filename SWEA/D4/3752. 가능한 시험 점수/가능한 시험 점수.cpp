#include<iostream>
#include<set>
#include<cstring>
#include<algorithm>

using namespace std;

int N, cnt;
int score[100];
bool check[10001];

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> N;
		memset(check, 0, sizeof(check));
		check[0] = true;
		int sum = 0;
		cnt = 0;
		for (int i = 0; i < N; i++) {
			cin >> score[i];
			for (int j = sum; j>=0 ; j--)
				if (check[j]) check[j + score[i]] = true;
			sum += score[i];
			check[score[i]] = true;
		}

		for (int i = 0; i <= sum; i++)
			if (check[i]) cnt++;

		cout << "#" << test_case << " " << cnt << "\n";
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}