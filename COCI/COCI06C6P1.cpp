/*
 * https://dmoj.ca/problem/coci06c6p1
 */

#include <iostream>
#include <map>
using namespace std;

int main() {
    int N;
    cin >> N;
    map<string,int> m;
    int totalTaken = 0;
    int count = 0; //scold
    string current;
    for (int i = 0; i < N; i++) {
        cin >> current;
        if (m[current]++ > (totalTaken - m[current] + 1) && totalTaken != 0) {
            count++;
        }
        totalTaken++;
    }
    cout << count;
}

