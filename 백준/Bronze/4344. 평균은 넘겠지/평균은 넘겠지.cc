#include <iostream>
#include<iomanip>
using namespace std;

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int k;
		cin >> k;

		int* p = new int[k];

		int tot = 0;
		int up = 0;
		for (int i = 0; i < k; i++)
		{
			cin >> p[i];
			tot += p[i];
		}

		for (int i = 0; i < k; i++)
		{
			if (double(p[i]) > double(tot / k))	up++;
		}
		cout << fixed << setprecision(3);
		cout << double(up) / k * 100 << "%" << "\n";
	}
}