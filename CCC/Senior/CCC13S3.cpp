/*
 * https://dmoj.ca/problem/ccc13s3
 */

#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

int T, G;

int winningCombinations(set<pair<int, int>> gamesToCompleteSet, vector<int> &scores) {
    if (gamesToCompleteSet.empty()) {
        int top = *max_element(scores.begin(), scores.end());
        return top == scores[T] && count(scores.begin(), scores.end(), top) == 1;
    }

    pair<int, int> curr = *gamesToCompleteSet.begin();
    gamesToCompleteSet.erase(curr);


    vector<int> scoreIfAWon = scores;
    vector<int> scoreIfBWon = scores;
    vector<int> scoreIfTie = scores;

    scoreIfAWon[curr.first] += 3;
    scoreIfBWon[curr.second] += 3;
    scoreIfTie[curr.first]++;
    scoreIfTie[curr.second]++;

    int sum = 0;
    
    sum += winningCombinations(gamesToCompleteSet, scoreIfAWon);
    sum += winningCombinations(gamesToCompleteSet, scoreIfBWon);
    sum += winningCombinations(gamesToCompleteSet, scoreIfTie);

    return sum;
}

int main() {
    vector<int> scores(5);
    set<pair<int, int>> gamesToCompleteSet;
    gamesToCompleteSet.emplace(1, 2);
    gamesToCompleteSet.emplace(1, 3);
    gamesToCompleteSet.emplace(1, 4);
    gamesToCompleteSet.emplace(2, 3);
    gamesToCompleteSet.emplace(2, 4);
    gamesToCompleteSet.emplace(3, 4);

    scanf("%i", &T);
    scanf("%i", &G);

    int A, B, Sa, Sb;
    for (int i = 0; i < G; i++) {
        scanf("%i %i %i %i", &A, &B, &Sa, &Sb);
        if (Sa > Sb) {
            scores[A] += 3;
        } else if (Sb > Sa) {
            scores[B] += 3;
        } else {
            scores[A]++;
            scores[B]++;
        }
        gamesToCompleteSet.erase(make_pair(A, B));
    }
    printf("%i\n", winningCombinations(gamesToCompleteSet,scores));
}
