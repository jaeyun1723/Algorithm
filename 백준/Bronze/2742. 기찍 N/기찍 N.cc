#include<iostream>
using namespace std;

int main() {
	
	ios_base::sync_with_stdio(false);

	int N;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cout << N - i << '\n';
	}
	return 0;
}