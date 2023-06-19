#include <iostream>
using namespace std;

int main() {
	int k, i;
	int t = 0;
	cin >> k;

	for (i = 1; i <= k; i++) {
		t += i;
	}
	cout << t << endl;
}