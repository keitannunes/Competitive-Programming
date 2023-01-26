#include <iostream>
using namespace std;

int calculateWeight(int b[4]) {
    int sum = 0;
    for (int i = 0; i < 4; i++) {
        sum += b[i];
    }
    return sum;
}

void push(int b[4], int val) {
    b[3] = b[2];
    b[2] = b[1];
    b[1] = b[0];
    b[0] = val;
}

int main() {
    int bridge[4] = {0};
    int W, N;
    cin >> W;
    cin >> N;
    int car;
    int i;
    for (i = 0; i < N; i++) {
        cin >> car;
        push(bridge,car);
        if (calculateWeight(bridge) > W) {
            break;
        }
    }
    cout << i << endl;
}
