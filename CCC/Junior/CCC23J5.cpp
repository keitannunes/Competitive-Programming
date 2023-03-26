/*
 * https://dmoj.ca/problem/ccc23j5
 */

#include <bits/stdc++.h>

using namespace std;
int R,C; //C = x, R = y
enum Dir {
    N,NE,E,SE,S,SW,W,NW,NONE
};

int recursiveFindDiagWords(vector<vector<char>>& matrix, int y, int x, const string& sub, Dir d, bool turned) {
    if (sub.empty()) return 1;
    int sum = 0;
    if (x > 0) {
        if ((d == SW || d == NONE || !turned) && y > 0 && matrix[y - 1][x - 1] == sub[0]) sum += recursiveFindDiagWords(matrix, y - 1, x - 1, sub.substr(1), SW,(d != NONE && d != SW) || turned); // SW
        if ((d == NW || d == NONE || !turned) && y + 1 < R && matrix[y + 1][x - 1] == sub[0]) sum += recursiveFindDiagWords(matrix, y + 1, x - 1, sub.substr(1), NW,(d != NONE && d != NW) || turned); // NW
    }
    if (x + 1 < C) {
        if ((d == SE || d == NONE || !turned) && y > 0 && matrix[y - 1][x + 1] == sub[0]) sum += recursiveFindDiagWords(matrix, y - 1, x + 1, sub.substr(1), SE,(d != NONE && d != SE) || turned); // SE
        if ((d == NE || d == NONE || !turned) && y + 1 < R && matrix[y + 1][x + 1] == sub[0]) sum += recursiveFindDiagWords(matrix, y + 1, x + 1, sub.substr(1), NE,(d != NONE && d != NE) || turned); // NE
    }
    return sum;
}
int recursiveFindHVWords(vector<vector<char>>& matrix, int y, int x, const string& sub, Dir d, bool turned) {
    if (sub.empty()) return 1;
    int sum = 0;
    if ((d == W || d == NONE || !turned) && x > 0 && matrix[y][x - 1] == sub[0]) sum += recursiveFindHVWords(matrix, y, x - 1, sub.substr(1), W,(d != NONE && d != W) || turned); // W
    if ((d == E || d == NONE || !turned) && x + 1 < C && matrix[y][x + 1] == sub[0]) sum += recursiveFindHVWords(matrix, y, x + 1, sub.substr(1), E,(d != NONE && d != E) || turned); // E
    if ((d == S || d == NONE || !turned) && y > 0 && matrix[y - 1][x] == sub[0]) sum += recursiveFindHVWords(matrix, y - 1, x, sub.substr(1), S,(d != NONE && d != S) || turned); // S
    if ((d == N || d == NONE || !turned) && y + 1 < R && matrix[y + 1][x] == sub[0]) sum += recursiveFindHVWords(matrix, y + 1, x, sub.substr(1), N,(d != NONE && d != N) || turned); //N
    return sum;
}

int main() {
    string word;
    cin >> word;
    scanf("%i",&R);
    scanf("%i",&C);
    vector<vector<char>> matrix(R);
    for (auto& r : matrix) {
        r = vector<char>(C);
        for (auto& c : r) {
            cin >> c;
        }
    }
    int sum = 0;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (matrix[i][j] == word[0]) {
                sum += recursiveFindDiagWords(matrix,i,j,word.substr(1), NONE, false);
                sum += recursiveFindHVWords(matrix,i,j,word.substr(1), NONE, false);
            }
        }
    }
    cout << sum;
}
