/*
https://dmoj.ca/problem/ccc09s4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC09S4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int[][] graph = new int[N+1][N+1];
        for (int[] g : graph) {
            Arrays.fill(g, Integer.MAX_VALUE);
        }
        HashMap<Integer, Integer> stores = new HashMap<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[x][y] = w;
            graph[y][x] = w;
        }
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            stores.put(x, p);
        }
        int D = Integer.parseInt(br.readLine());
        int minCost = Integer.MAX_VALUE;
        int[] distances = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        visited[0] = true; //empty index
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[D] = 0;
        int numVisited = 0;
        TreeMap<Integer, ArrayList<Integer>> NWCDBNV = new TreeMap<>();
        int current = D;
        while (numVisited <= T) {
            int localMin = Integer.MAX_VALUE;
            int nextNodeToVisit = 0;
            for (int child = 1; child < N; child++) {
                if (graph[current][child] == Integer.MAX_VALUE) continue;
                int childDistance = graph[current][child] + distances[current];
                if (childDistance < distances[child]) {
                    distances[child] = childDistance;
                    if (!NWCDBNV.containsKey(childDistance)) {
                        NWCDBNV.put(childDistance, new ArrayList<>());
                    }
                    NWCDBNV.get(childDistance).add(child);
                    if (!visited[child]) {
                        if (graph[current][child] < localMin) {
                            localMin = graph[current][child];
                            nextNodeToVisit = child;
                        }
                    }
                }
            }
            if (stores.containsKey(current)) {
                if (stores.get(current) + distances[current] < minCost) {
                    minCost = stores.get(current) + distances[current];
                }
            }
            visited[current] = true;
            NWCDBNV.remove(current);
            if (nextNodeToVisit == 0) {//DEAD END
                if (NWCDBNV.isEmpty()) break;
                int key = NWCDBNV.firstKey();
                current = NWCDBNV.get(key).remove(0);
                if (NWCDBNV.get(key).size() == 0) { //lmao could have used isEmpty();
                    NWCDBNV.remove(key);
                }
            } else {
                current = nextNodeToVisit;
            }
            numVisited++;
        }
        System.out.println(minCost);
    }
}
