#include<iostream>
using namespace std;

int d(int n)	// 정수n과 n의 각자리 숫자의 합
{
	int sum = n;
	int digit[5] = {0};
	digit[0] = n % 10;
	digit[1] = (n / 10) % 10;
	digit[2] = (n / 100) % 10;
	digit[3] = (n / 1000) % 10;
	digit[4] = (n / 10000);
	for (int i = 0; i < 5; i++)
		sum += digit[i];
	return sum;
}

int main() {
	int num[10000] = { 0 };

	for (int i = 1; i < 10000; i++) {
		int n = 0;
		n = d(i);
		if (n <= 10000) num[n - 1]++;
	}
	/* 
	n=d(1)=1+1=2 num[1]++-> num[1]=1 
	n=d(2)=2+2=4 num[3]++-> num[3]=1
	n=3+3=6 num[5]=1
	4 4  8 7
	5 5 10 9
	6 6 12 11
	*/
	for (int j = 0; j < 10000; j++)
		if (num[j] == 0)
			cout << j + 1 << '\n';
}