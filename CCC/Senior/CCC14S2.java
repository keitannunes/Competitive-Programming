
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CCC14S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer names1 = new StringTokenizer(br.readLine());
        StringTokenizer names2 = new StringTokenizer(br.readLine());
        HashMap<String, String> map = new HashMap<>();
        while (names1.hasMoreTokens()) {
            String name1 = names1.nextToken();
            String name2 = names2.nextToken();
            if (name1.equals(name2)) {
                System.out.println("bad");
                return;
            }
            if (!map.containsKey(name1)) {
                map.put(name1, name2);
                map.put(name2, name1);
            } else if (!map.get(name1).equals(name2)) {
                System.out.println("bad");
                return;
            }
        }
        System.out.println("good");
    }
}
