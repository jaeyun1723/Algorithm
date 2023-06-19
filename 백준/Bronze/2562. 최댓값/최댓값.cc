#include <iostream>
using namespace std;

const int MAX = 100;
int main() {
	int n, i;
	int k = -MAX;
	int m = 0;

	for (i = 1; i <= 9; i++) {
		cin >> n;
		if (k <= n) {
			k = n;
			m = i;
		}
	}
	cout << k << " " << m << endl;
}
