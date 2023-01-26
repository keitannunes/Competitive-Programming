#include <iostream>
#include <map>
using namespace std;

int main() {

    map<int,int> map;
    map[9] = 34;
    map[40] = 64;
    map[54] = 19;
    map[67] = 86;
    map[90] = 48;
    map[99] = 77;

    int current = 1;
    int val;
    while (true) {
        cin >> val;
        if (val == 0) {
            cout << "You Quit!" << endl;
            break;
        }
        current += val;
        if (current > 100) {
            current -= val;
        }

        if (map.count(current)) {
            current = map[current];
        }

        if (current == 100) {
            cout << "You are now on square " << 100 << '\n';
            cout << "You Win!" << endl;
            break;
        } else {
            cout << "You are now on square " << current << '\n';
        }
    }
}
