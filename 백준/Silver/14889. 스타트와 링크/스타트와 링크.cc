#include <iostream>
#include <cmath>
using namespace std;
int v[20][20];
bool visited[20];
int N;
int minimum = 1234567890;
void slgap(int cnt, int idx) {
	if (cnt == N / 2) {
		int start = 0;
		int link = 0; 
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
					start += v[i][j] + v[j][i];
				}
				else if (!visited[i] && !visited[j]) {
					link += v[i][j] + v[j][i];
				}
			}
		}
		minimum = fmin(minimum, abs(start - link));
		return;
	}
	for (int i = 0; i < N; i++) {
		if (visited[i] == false && i > idx) {
			visited[i] = true;
			slgap(cnt + 1, i);
			visited[i] = false;
		}
	}

}


int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> v[i][j];
		}
	}
	slgap(0, -1);
	cout << minimum << endl;

}