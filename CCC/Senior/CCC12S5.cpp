/*
 * https://dmoj.ca/problem/ccc12s5
 */

#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

int R, C, K, cr, cc;
pair<int,int> dest;
map<pair<int,int>, int> paths;
vector<pair<int, int>> cats;

int recursiveFindPaths(pair<int,int> current) {
    if (current == dest) {
        paths[current] = 1;
        return 1;
    }
    pair<int,int> right = make_pair(current.first,current.second+1);
    pair<int,int> down = make_pair(current.first+1,current.second);
    int sum = 0;
    if (!count(cats.begin(), cats.end(),right) && right.second <= C) {
        if (paths.count(right)) {
            sum += paths[right];
        } else {
            int num = recursiveFindPaths(right);
            paths[right] = num;
            sum += num;
        }
    }
    if (!count(cats.begin(), cats.end(),down) && down.first <= R) {
        if (paths.count(down)) {
            sum += paths[down];
        } else {
            int num = recursiveFindPaths(down);
            paths[down] = num;
            sum += num;
        }
    }
    return sum;
}

int main() {
    scanf("%d %d", &R, &C);
    dest = make_pair(R,C);
    cin >> K;
    for (int i = 0; i < K; i++) {
        scanf("%d %d", &cr, &cc);
        cats.emplace_back(cr,cc);
    }
    cout << recursiveFindPaths(make_pair(1,1));
}
