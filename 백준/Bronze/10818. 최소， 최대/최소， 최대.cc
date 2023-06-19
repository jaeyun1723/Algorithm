#include <iostream>
using namespace std;

const int MAX = 1000000;

int main(void) {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int n;
	cin >> n;

	int a = 0;

	int min = MAX;
	int max = -MAX;

	for (int i = 0; i < n; i++) {
		cin >> a;
		if (min > a) min = a;
		if (max < a) max = a;
	}

	cout << min << " " << max;

}