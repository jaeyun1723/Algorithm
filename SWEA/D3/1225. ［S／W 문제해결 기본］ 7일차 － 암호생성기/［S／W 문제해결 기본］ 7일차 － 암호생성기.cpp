#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include<cstring>
using namespace std;

int num[8];

//bool check() {
//	for (int i = 0; i < 8; i++) if (num[i] > 9) return true;
//	return false;
//}

int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int N;
		cin >> N;
		for (int i = 0; i < 8; i++)
			cin >> num[i];
		int turn = 0;
		bool flag = false;
		while (!flag) {
			for (int i = 1; i <= 5; i++) {
				if (flag) break;
				num[turn] -= i;
				if (num[turn] <= 0) {
					num[turn] = 0;
					flag = true;
				}
				turn = (++turn) % 8;
			}
		}
		cout << "#" << test_case << " ";
		for (int i = 0; i <8 ; i++) {
			cout << num[(turn + i) % 8] << " ";
		}
		cout << '\n';
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}