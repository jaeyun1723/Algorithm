import java.util.*;

class Solution {

    public static int[][] rotateKey(int[][] key) { // 90도 시계방향
        int[][] newKey = new int[key.length][key.length];
        for (int i = 0; i < newKey.length; i++) {
            for (int j = 0; j < newKey.length; j++) {
                newKey[i][j] = key[j][newKey.length - i - 1];
            }
        }
        return newKey;
    }

    public static boolean isKey(int[][] map, int[][] key, int lockLen) {
        int keyLen = key.length;
        int mapLen = map.length;
        // setting
        for (int i = 0; i <= mapLen - keyLen; i++) {
            for (int j = 0; j <= mapLen - keyLen; j++) {
                // 0. 키 시작인덱스
                // 1. 키를 더해줌
                for (int x = 0; x < keyLen; x++) {
                    for (int y = 0; y < keyLen; y++) {
                        map[i + x][j + y] += key[x][y];
                    }
                }
                boolean flag = true;
                for (int x = keyLen - 1; x < keyLen + lockLen - 1; x++) {
                    for (int y = keyLen - 1; y < keyLen + lockLen - 1; y++) {
                        if (map[x][y] != 1) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        break;
                    }
                }
                if (flag) {
                    return true;
                }

                for (int x = 0; x < keyLen; x++) {
                    for (int y = 0; y < keyLen; y++) {
                        map[i + x][j + y] -= key[x][y];
                    }
                }

            }
        }
        return false;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int k = key.length; // 3
        int l = lock.length; // 3
        int size = k * 2 + l - 2; // 7
        int[][] map = new int[size][size];

        for (int i = k - 1; i < l + k - 1; i++) {
            for (int j = k - 1; j < l + k - 1; j++) {
                map[i][j] = lock[i - (k - 1)][j - (k - 1)];
            }
        }

        for (int i = 0; i < 4; i++) {
            if (isKey(map, key, l)) {
                return true;
            }
            key = rotateKey(key);


        }

        return false;
    }
}