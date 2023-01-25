import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CCC01S3 {

    public static int charToInt(char c) {
        return c - 65;
    }

    public static char intToChar(int c) {
        return (char) (c + 65);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer>[] adjList = new ArrayList[26];
        ArrayList<String> paths = new ArrayList<>();
        while (true) {
            String input = br.readLine();
            if (!input.equals("**")) {
                paths.add(input);
                int a = charToInt(input.charAt(0));
                int b = charToInt(input.charAt(1));
                if (adjList[a] == null) {
                    adjList[a] = new ArrayList<>();
                }
                if (adjList[b] == null) {
                    adjList[b] = new ArrayList<>();
                }
                adjList[a].add(b);
                adjList[b].add(a);
            } else {
                break;
            }
        }
        Graph graph = new Graph(adjList);
        ArrayList<ArrayList<Integer>> allPaths = graph.findAllPaths(0, 1);
        int commonPaths = 0;
        for (int i = 0; i < allPaths.get(0).size() - 1; i++) {
            List<Integer> subList = allPaths.get(0).subList(i, i + 2);
            boolean subListInAllLists = true;
            for (ArrayList<Integer> path : allPaths) {
                if (Collections.indexOfSubList(path, subList) == -1) {
                    subListInAllLists = false;
                    break;
                }
            }
            if (subListInAllLists) {
                commonPaths++;
                StringBuilder o = new StringBuilder();
                char a = intToChar(subList.get(0));
                char b = intToChar(subList.get(1));
                o.append(a);
                o.append(b);
                if (!paths.contains(o.toString())) {
                    o.delete(0, 2);
                    o.append(b);
                    o.append(a);
                }
                System.out.println(o);
            }
        }
        System.out.printf("There are %d disconnecting roads.\n",commonPaths);
    }
}

class Graph {
    private final ArrayList<Integer>[] graph;
    public ArrayList<ArrayList<Integer>> paths;

    public Graph(ArrayList<Integer>[] graph) {
        this.graph = graph;
        this.paths = new ArrayList<>();
    }

    public ArrayList<ArrayList<Integer>> findAllPaths(int s, int f) {
        boolean[] visited = new boolean[26];
        ArrayList<Integer> localPath = new ArrayList<>();
        localPath.add(s);
        findAllPathsRecursive(s, f, visited, localPath);
        return this.paths;
    }

    private void findAllPathsRecursive(int u, int d, boolean[] visited, ArrayList<Integer> localPath) {
        if (u == d) {
            ArrayList<Integer> DC = new ArrayList<>(localPath); //deep copy
            this.paths.add(DC);
            return;
        }
        visited[u] = true;
        for (int i : graph[u]) {
            if (!visited[i]) {
                localPath.add(i);
                findAllPathsRecursive(i, d, visited, localPath);
                localPath.remove((Integer) i);
            }
        }
        visited[u] = false;
    }
}