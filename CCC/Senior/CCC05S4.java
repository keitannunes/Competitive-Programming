/*
https://dmoj.ca/problem/ccc05s4
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class CCC05S4 {
    static HashMap<String, ArrayList<String>> graph;

    public static int findDepth(String node, String parent) {
        int maxDepth = 0;
        for (String child : graph.get(node)) {
            if (child.equals(parent)) continue;
            int depth = findDepth(child,node);
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }
        return maxDepth+1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            graph = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            String lastInput, root;
            lastInput = root = "Home";
            for (int j = 0; j < N; j++) {
                if (!graph.containsKey(lastInput)) {
                    graph.put(lastInput, new ArrayList<>());
                }
                String input = br.readLine();
                graph.get(lastInput).add(input);
                if (j == N - 1) {
                    if (!input.equals("Home")) {
                        if (!graph.containsKey(input)) {
                            graph.put(input, new ArrayList<>());
                        }
                        root = input;
                        graph.get(input).add(graph.get("Home").get(0));
                        graph.remove("Home");
                    }
                }
                lastInput = input;
            }
            int optimal = (findDepth(root,null) - 1)*20;
            int original = N*10;
            System.out.println(original-optimal);
        }
    }
}
