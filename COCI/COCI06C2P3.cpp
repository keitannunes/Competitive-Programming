/*
 * https://dmoj.ca/problem/coci06c2p3
 */

#include <iostream>

using namespace std;

bool contains(char arr[], int N, char val) {
    for (int i = 0; i < N; i++) {
        if (arr[i] == val) {
            return true;
        }
    }
    return false;
}

int main() {
    int N1, N2, T;
    cin >> N1;
    cin >> N2;
    char group1[N1];
    char group2[N2];
    char out[N1 + N2];
    for (int i = 0; i < N1; i++) {
        cin >> group1[i];
        out[N1-i-1] = group1[i];
    }
    for (int i = 0; i < N2; i++) {
        cin >> group2[i];
        out[N1+i] = group2[i];
    }

    cin >> T;

    for (int i = 0; i < T; i++) {
        for (int j = 0; j < N1+N2-1; j++) {
            if (contains(group1,N1,out[j]) && contains(group2,N2,out[j+1])) {
                char temp = out[j];
                out[j] = out[j+1];
                out[j+1] = temp;
                j++;
            }
        }
    }
    for(char c : out) {
        cout << c;
    }
    cout << endl;
}

