/*
 * https://dmoj.ca/problem/coci06c3p5
 */

#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

vector<vector<int>> graph(10000);
vector<ll> dp(10000, -2);
vector<char> unreachable(10000);
set<int> visited;

bool bfs(int start) { //true - reachable, false - unreachable
    if (unreachable[start] == -1) {
        return true;
    } else if (unreachable[start] == 1) {
        return false;
    }
    vector<bool> ifVisited(10000);
    set<int> bfsVisited;
    queue<int> q;
    q.push(start);
    int curr;
    while (!q.empty()) {
        curr = q.front();
        q.pop();
        bfsVisited.insert(curr);
        ifVisited[curr] = true;
        if (dp[curr] > 0 || unreachable[curr] == -1 || curr == 1) {
            for (int u: bfsVisited) {
                unreachable[u] = -1;
            }
            return true;
        }
        if (unreachable[curr] == 1) return false;
        for (int child: graph[curr]) {
            if (!ifVisited[child]) q.push(child);
        }
    }
    for (int u: bfsVisited) {
        unreachable[u] = 1;
        dp[u] = -1;
    }
    return false;
}

// -1 = unreachable
// -2 = need to calculate DP;
// -3 = INF
ll recursiveSearch(int u) {
    if (u == 1) {
        return 1;
    }
    visited.insert(u);
    ll sum = 0;
    for (auto child: graph[u]) {
        if (binary_search(visited.begin(), visited.end(), child)) {
            if (bfs(child)) return -3; //if the end is visitable return -3
        }
        if (dp[child] == -2) {
            dp[child] = recursiveSearch(child);
        }
        if (dp[child] == -1) {
            continue;
        }
        if (dp[child] == -3) {
            return -3;
        }
        if (dp[child] > 999999999 || sum > 999999999) {
            sum = 10000000000LL + (sum + dp[child]) % 10000000000LL;
        } else {
            sum += dp[child];
        }
    }
    visited.erase(u);
    return sum;
}

int main() {
    int N, M, x, y;
    scanf("%i %i", &N, &M);
    for (int i = 0; i < M; i++) {
        scanf("%i %i", &x, &y);
        graph[x - 1].push_back(y - 1);
    }
    ll ans = recursiveSearch(0);

    if (ans == -3) {
        printf("inf\n");
    } else if (ans > 999999999) {
        string ret(9, '\0');
        for (int i = 0; i < 9; i++) {
            ret[9 - i - 1] = ans % 10 + 48;
            ans /= 10;
        }
        cout << ret << endl;
    } else {
        printf("%lli\n", ans);
    }
}