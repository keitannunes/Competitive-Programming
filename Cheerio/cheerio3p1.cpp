/*
 * https://dmoj.ca/problem/cheerio3p1/
 */

#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

int N,M;

int main() {
    scanf("%i %i", &N,&M);
    char matrix[N][M];
    for (int i = 0; i < N; i++) {
        for (char& val : matrix[i]) {
            cin >> val;
        }
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (matrix[i][j] == 'W') {
                if (i - 1 >= 0 && matrix[i - 1][j] != 'W') matrix[i - 1][j] = 'C';
                if (i + 1 < N && matrix[i + 1][j] != 'W') matrix[i + 1][j] = 'C';
                if (j - 1 >= 0 && matrix[i][j - 1] != 'W') matrix[i][j - 1] = 'C';
                if (j + 1 < M && matrix[i][j + 1] != 'W') matrix[i][j + 1] = 'C';
            }
        }
    }
    for (int i = 0; i < N; i++) {
        for (char& val : matrix[i]) {
            cout << val;
        }
        cout << '\n';
    }
}
