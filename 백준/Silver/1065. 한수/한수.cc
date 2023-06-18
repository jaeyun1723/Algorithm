#include<iostream>
using namespace std;

int arith(int n) {
	int digit[3] = { 0 };
	int num = 0;
	for (int i = 1; i <= n; i++) {
		digit[0] = i % 10;
		digit[1] = (i / 10) % 10; 
		digit[2] = i / 100; 
		if (digit[2] == 0) num++;
		else if (digit[2] - digit[1] == digit[1] - digit[0]) num++;
	}
	return num;
}

int main() {
	int k;
	cin >> k;
	cout << arith(k) << endl;
}