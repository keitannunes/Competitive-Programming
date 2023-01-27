/*
 * https://dmoj.ca/problem/ccc07s4
 */

#include <iostream>
#include <vector>

using namespace std;

int findPathsRecursive(int u, int d, vector<int> *graph, bool *visited, int *numOfPaths) {
    if (u == d) {
        return 1;
    } else if (numOfPaths[u] != 0) {
        return numOfPaths[u];
    }
    visited[u] = true;
    int sum = 0;
    for (int c : graph[u]) {
        if (!visited[c]) {
            sum += findPathsRecursive(c,d,graph,visited,numOfPaths);
        }
    }
    visited[u] = false;
    numOfPaths[u] = sum;
    return sum;
}

int main() {
    int n,x,y;
    cin >> n;
    vector<int> graph[n];
    bool visited[n];
    int numOfPaths[n];

    for (int i = 0; i < n; i++) {
        visited[i] = false;
        numOfPaths[i] = 0;
    }

    while (true) {
        cin >> x >> y;
        if (x == y) {
            break;
        }
        graph[x-1].push_back(y-1);
    }
    cout << findPathsRecursive(0,n-1,graph,visited,numOfPaths);

}
