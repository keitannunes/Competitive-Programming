/*
https://dmoj.ca/problem/ccc09s3
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class CCC09S3 {
    static HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static void initializeGraph() {
        for (int i = 1; i < 19; i++) {
            graph.put(i,new HashSet<>());
        }
        graph.get(1).add(6);
        graph.get(2).add(6);
        graph.get(3).add(6);
        graph.get(3).add(4);
        graph.get(3).add(5);
        graph.get(3).add(15);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(4).add(6);
        graph.get(5).add(4);
        graph.get(5).add(3);
        graph.get(5).add(6);
        for (int i = 1; i < 6; i++) {
            graph.get(6).add(i);
        }
        graph.get(6).add(7);
        graph.get(7).add(6);
        graph.get(7).add(8);
        graph.get(8).add(7);
        graph.get(8).add(9);
        graph.get(9).add(8);
        graph.get(9).add(12);
        graph.get(9).add(10);
        graph.get(10).add(9);
        graph.get(10).add(11);
        graph.get(11).add(10);
        graph.get(11).add(12);
        graph.get(12).add(9);
        graph.get(12).add(11);
        graph.get(12).add(13);
        graph.get(13).add(12);
        graph.get(13).add(14);
        graph.get(13).add(15);
        graph.get(14).add(13);
        graph.get(15).add(13);
        graph.get(15).add(3);
        graph.get(16).add(17);
        graph.get(16).add(18);
        graph.get(17).add(16);
        graph.get(17).add(18);
        graph.get(18).add(17);
        graph.get(18).add(16);
    }

    static void i(int x, int y) {
        if (!graph.containsKey(x)) {
            graph.put(x, new HashSet<>());
        }
        if (!graph.containsKey(y)) {
            graph.put(y, new HashSet<>());
        }
        graph.get(x).add(y);
        graph.get(y).add(x);
    }

    static void d(int x, int y) {
        graph.get(x).remove(y);
        graph.get(y).remove(x);
    }

    static int n(int x) {
        return graph.get(x).size();
    }

    static int s(int x, int y) {
        HashMap<Integer,Integer> distances = new HashMap<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        distances.put(x,0);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == y) {
                return distances.get(current);
            }
            for (int child : graph.get(current)) {
                if (!distances.containsKey(child)) {
                    distances.put(child,distances.get(current) + 1);
                    queue.offer(child);
                }
            }
        }
        return -1;
    }

    static int f(int x) {
        HashSet<Integer> friendsOfFriends = new HashSet<>();
        for (int friend : graph.get(x)) {
            friendsOfFriends.addAll(graph.get(friend));
        }
        friendsOfFriends.remove(x);
        friendsOfFriends.removeAll(graph.get(x));
        return friendsOfFriends.size();
    }

    public static void main(String[] args) throws IOException {
        initializeGraph();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;
        do {
            String input = br.readLine();
            switch (input) {
                case "i": {
                    int x = Integer.parseInt(br.readLine());
                    int y = Integer.parseInt(br.readLine());
                    i(x,y);
                    break;
                }
                case "d": {
                    int x = Integer.parseInt(br.readLine());
                    int y = Integer.parseInt(br.readLine());
                    d(x,y);
                    break;
                }
                case "n": {
                    int x = Integer.parseInt(br.readLine());
                    System.out.println(n(x));
                    break;
                }
                case "f": {
                    int x = Integer.parseInt(br.readLine());
                    System.out.println(f(x));
                    break;
                }
                case "s": {
                    int x = Integer.parseInt(br.readLine());
                    int y = Integer.parseInt(br.readLine());
                    int d = s(x,y);
                    if (d == -1) {
                        System.out.println("Not connected");
                    } else {
                        System.out.println(d);
                    }
                    break;
                }
                case "q": {
                   exit = true;
                   break;
                }
            }
        } while (!exit);
    }
}
