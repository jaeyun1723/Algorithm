#include <iostream>
#include <string>

using namespace std;

int main() {
	int cnt = 0, i = 666;
	int num;
	cin >> num;
	while (true) {
		string s = to_string(i);
		if (s.find("666") != -1) cnt++;
		if (cnt == num) {
			cout << i;
			return 0;
		}
		i++;
	}
}