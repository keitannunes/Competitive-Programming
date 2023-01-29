/*
 * https://dmoj.ca/problem/ccc00s4
 */

#include <bits/stdc++.h>

using namespace std;


int main() {
    int dist, N;
    cin >> dist;
    cin >> N;
    vector<int> clubs(N);
    vector<int> scores(dist + 1);
    int num;
    for (int i = 0; i < N; i++) {
        cin >> num;
        clubs[i] = num;
    }

    scores[0] = 1;

    for (int currDist = 1; currDist <= dist; currDist++) {
        for (int club: clubs) {
            if (currDist - club < 0 || scores[currDist - club] == 0) continue;
            if (scores[currDist] == 0) scores[currDist] = scores[currDist - club] + 1;
            else scores[currDist] = min(scores[currDist], scores[currDist - club] + 1);
        }
    }
    int ans = scores[dist] - 1;
    if (ans == -1) {
        cout << "Roberta acknowledges defeat.\n";
    } else {
        printf("Roberta wins in %d strokes.\n", ans);
    }
}

