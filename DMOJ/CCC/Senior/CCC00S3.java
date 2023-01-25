import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CCC00S3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, new HashSet<>());
            String input;
            do {
                input = br.readLine();
                int offset = input.indexOf("<A HREF=\"");
                while (offset != -1) {
                    int endIndex = input.indexOf("\">", offset);
                    String url = input.substring(offset + 9, endIndex);
                    System.out.printf("Link from %s to %s\n", name, url);
                    map.get(name).add(url);
                    offset = input.indexOf("<A HREF=\"", offset + 1);
                }
            } while (!input.contains("</HTML>"));
        }
        HashMap<String, HashSet<String>> accessible = new HashMap<>();
        for (String start : map.keySet()) {
            accessible.put(start, new HashSet<>());

        }
        for (String start : map.keySet()) {
            HashSet<String> visited = new HashSet<>();
            ArrayDeque<String> queue = new ArrayDeque<>();
            queue.offer(start);
            while (!queue.isEmpty()) {
                String current = queue.poll();
                visited.add(current);
                accessible.get(start).add(current);
                if (map.get(current) != null) {
                    for (String child : map.get(current)) {
                        if (accessible.containsKey(child)) {
                            accessible.get(start).addAll(accessible.get(current));
                        }
                        if (!visited.contains(child)) {
                            queue.offer(child);
                        }
                    }
                }
            }
        }
        while (true) {
            String first = br.readLine();
            if (first.equals("The End")) break;
            String second = br.readLine();
            if (accessible.get(first) == null || !accessible.get(first).contains(second)) {
                System.out.printf("Can't surf from %s to %s.\n", first, second);
            } else {
                System.out.printf("Can surf from %s to %s.\n", first, second);
            }
        }
    }
}
