/*
 * https://dmoj.ca/problem/coci07c6p2
 */

#include <iostream>

using namespace std;

int main() {
    int N, L, lastDistance, time = lastDistance = 0;
    cin >> N;
    cin >> L;
    for (int i = 0; i < N; i++) {
        int D,R,G;
        cin >> D;
        cin >> R;
        cin >> G;
        time += D-lastDistance;
        lastDistance = D;
        if (time%(R+G) < R) {
            time += R - time%(R+G);
        }
    }
    time += L-lastDistance;
    cout << time;
}

