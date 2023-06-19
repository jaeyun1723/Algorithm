#include<iostream>
#include<string>
#include<cstring>
#include<vector>
#include<cmath>
#include<cstring>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
#include<deque>
#include<bitset>
using namespace std;

#define MAX 30
typedef long long ll;
int N, qry, weight[30];
bool visit[MAX + 1][MAX * 500 + 1];
void available(int cnt, int res) {
	if (cnt > N) return;
	if (visit[cnt][res] == true) return;
	visit[cnt][res] = true;
	available(cnt + 1, res + weight[cnt]);	// 추의 갯수 증가 해당 추를 구슬이 없는 저울에 올린 경우
	available(cnt + 1, res);	// 추의 갯수 증가, 어느 저울에도 올리지 않을 경우
	available(cnt + 1, abs(res - weight[cnt]));	// 추의 갯수 증가, 해당 추를 구슬이 있는 저울에 올린 경우
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++)
		cin >> weight[i];
	cin >> qry;
	available(0, 0);
	while (qry--) {
		int wgt;
		cin >> wgt;
		if (wgt > MAX * 500) cout << "N ";
		else if (visit[N][wgt]) cout << "Y ";
		else cout << "N ";
	}
}