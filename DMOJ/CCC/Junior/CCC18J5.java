
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC18J5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            if (P == 0) {
                graph[i] = new int[]{-1};
                continue;
            }
            graph[i] = new int[P];
            for (int p = 0; p < P; p++) {
                int child = Integer.parseInt(st.nextToken()) - 1;
                graph[i][p] = child;
            }
        }

        int shortestDistance = 0;
        int[] distances = new int[N];
        int accessible = 1;
        distances[0] = 1;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        boolean exit = false;
        while (!exit && !queue.isEmpty()) {
            int current = queue.poll();
            for (int child : graph[current]) {
                if (child == -1) {
                    if (shortestDistance == 0)
                        shortestDistance = distances[current]; //I do the +1 subtraction here
                    continue;
                }
                if (distances[child] == 0) {
                    distances[child] = distances[current] + 1;
                    queue.offer(child);
                    accessible++;
                }
            }
        }
        System.out.println(accessible == N ? "Y" : "N");
        System.out.println(shortestDistance);
    }
}