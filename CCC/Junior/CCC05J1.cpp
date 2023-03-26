/*
 * https://dmoj.ca/problem/ccc05j1
 */

#include <bits/stdc++.h>

using namespace std;

int main() {
    int d,e,w;
    scanf("%i",&d);
    scanf("%i",&e);
    scanf("%i",&w);
    int pA = max(0,d-100)*25 + 15*e + 20*w;
    int pB = max(0,d-250)*45 + 35*e + 25*w;
    printf("Plan A costs %.2f\n",pA/100.0);
    printf("Plan B costs %.2f\n",pB/100.0);
    if (pA < pB) {
        printf("Plan A is cheapest.");
    } else if (pB < pA) {
        printf("Plan B is cheapest.");
    } else {
        printf("Plan A and B are the same price.");
    }
    return 0;
}
