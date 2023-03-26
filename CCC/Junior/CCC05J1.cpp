/*
 * https://dmoj.ca/problem/ccc05j1
 */

#include <bits/stdc++.h>

using namespace std;

int main() {
    int dayTime = 0;
    int eveningTime = 0;
    int nightTime = 0;
    double planA = 0.0;
    double planB = 0.0;
    double epsilon = 0.000001;
    std::cin >> dayTime;
    std::cin >> eveningTime;
    std::cin >> nightTime;
    for (int i = 100; i < dayTime; i++) {
        planA += 0.25;
    }
    planA += (eveningTime * 0.15);
    planA += (nightTime * 0.20);
    for (int j = 250; j < dayTime; j++) {
        planB += 0.45;
    }
    planB += (eveningTime * 0.35);
    planB += (nightTime * 0.25);
    printf("Plan A costs %.2f \n", planA);
    printf("Plan B costs %.2f \n", planB);
    if (std::abs(planA - planB) < epsilon) std::cout << "Plan A and B are the same price.";
    else if (planA > planB) std::cout << "Plan B is cheapest.";
    else std::cout << "Plan A is cheapest." ;
}
