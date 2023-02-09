/*
 * https://dmoj.ca/problem/cheerio3p2/
 */

#include <bits/stdc++.h>

using namespace std;

typedef long long ll;


int main() {
    int N, enemyAmmo, myAmmo, myScore;
    enemyAmmo = myAmmo = myScore = 0;
    scanf("%i", &N);
    char enemy[N];
    scanf("%s", enemy);

    for (int i = 0; i < N; i++) {
        char move = enemy[i];
        if (i == 0) {
            myAmmo++;
            if (move == 'R') enemyAmmo++;
        }
        else if (move == 'R') {
            enemyAmmo++;
            if (myAmmo > 0) {
                myAmmo--;
                myScore++;
            } else {
                myAmmo++;
            }
        } else if (move == 'F') {
            if (enemyAmmo > 0) enemyAmmo--; //block
            else {
                if (myAmmo > 0) {
                    myAmmo--;
                    myScore++;
                } else {
                    myAmmo++;
                }
            }
        } else { //they block
            myAmmo++;
        }
    }
    printf("%i\n", myScore);
}
