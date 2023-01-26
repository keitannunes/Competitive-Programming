
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CCC07S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.put(a,b);
        }

        ArrayList<Integer> uncheckedNodes = new ArrayList<>(graph.keySet());
        ArrayList<ArrayList<Integer>> friendCircles = new ArrayList<>(); //Friend and next friend
        int currentFriendCircle = 0;
        while (!uncheckedNodes.isEmpty()) {
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            friendCircles.add(new ArrayList<>());
            queue.offer(uncheckedNodes.get(0));
            while (!queue.isEmpty()) {
                int current = queue.poll();
                uncheckedNodes.remove((Integer)current);
                int child = graph.get(current);
                if (uncheckedNodes.contains(child))
                    queue.offer(child);
                friendCircles.get(currentFriendCircle).add(current);
            }
            currentFriendCircle++;
        }

        String input = br.readLine();
        while (!input.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (ArrayList<Integer> list : friendCircles) {
                if (list.contains(a)) {
                    if (list.contains(b)) {
                        int current = a;
                        int count = 0;
                        while (graph.get(current) != b) {
                            count++;
                            current = graph.get(current);
                        }
                        System.out.printf("Yes %d\n", count) ;
                    } else {
                        System.out.println("No");
                    }
                    break;
                }
            }
            input = br.readLine();
        }
    }
}
