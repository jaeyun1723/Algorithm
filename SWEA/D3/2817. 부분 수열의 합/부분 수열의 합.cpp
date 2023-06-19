#include<iostream>
#include<cstring>
#include<algorithm>

using namespace std;

int arr[20];
bool check[20];
int N, K, cnt;
void dfs(int idx, int sum)
{
	if (sum > K) return;
	if (sum == K) {
		cnt++;
		return;
	}
	for (int i = idx; i < N; i++) {
		sum += arr[i];
		if (sum <= K) dfs(i + 1, sum);
        sum -= arr[i];
	}
}

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> N >> K;
		memset(arr, 0, sizeof(arr));
		memset(check, false, sizeof(check));
		cnt = 0;
		for (int i = 0; i < N; i++)
			cin >> arr[i];
		dfs(0, 0);
		cout << "#" << test_case << " " << cnt << "\n";
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}