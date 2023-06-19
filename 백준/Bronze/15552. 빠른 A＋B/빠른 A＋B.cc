#include <iostream>
using namespace std;

int main() {
	int k, i;
	int a, b;
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> k;

	for (i = 1; i <= k; i++) {
		cin >> a >> b;
		cout << a + b << "\n";
	}
}
