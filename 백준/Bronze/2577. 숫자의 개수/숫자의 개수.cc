#include <iostream>

using namespace std;

int main() {

	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int a, b, c;
	int tot;
	cin >> a >> b >> c;
	tot = a * b * c;

	int arr[10] = { 0 };
	while (tot != 0) {
		arr[tot % 10] = arr[tot % 10] + 1;
		tot = tot / 10;
	}
	
	for (int i = 0; i < 10; i++) {
		cout << arr[i] << "\n";
	}
}