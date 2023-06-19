#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
using namespace std;
int num[11];
int op[4];
int n, mx, mn;
void DFS(int index, int val) {
    if (index == n) {
        if (val > mx) {
            //printf("mx val: %d\n", val);
            mx = val;
        }
        if (val < mn) {
            //printf("mn val: %d\n", val);
            mn = val;
        }
        return;
    }
    
    for (int i = 0; i < 4; i++) {
        //printf("index: %d일때: i=%d, val=%d\n", index, i, val);
        if (op[i] != 0) {
            op[i]--;
            //연산기호별 계산
            if (i == 0) {
                val += num[index];
                DFS(index + 1, val);
                val -= num[index];
            }
            else if (i == 1) {
                val -= num[index];
                DFS(index + 1, val);
                val += num[index];
            }
            else if (i == 2) {
                val *= num[index];
                DFS(index + 1, val);
                val /= num[index];
            }
            else if (i == 3) {
                val /= num[index];
                DFS(index + 1, val);
                val *= num[index];
            }
            op[i]++;
        }
    }
}
int main() {
    //1.수의 갯수
    //2.수 입력받기
    //3.덧 뺄 곱 나눗 갯수
    scanf("%d", &n);
    mx = -1987654321, mn = 1987654321;
    for (int i = 0; i < n; i++) {
        scanf("%d", &num[i]);
    }
    for (int i = 0; i < 4; i++) {
        scanf("%d", &op[i]);
    }
    DFS(1, num[0]);
    printf("%d\n%d", mx, mn);
}

