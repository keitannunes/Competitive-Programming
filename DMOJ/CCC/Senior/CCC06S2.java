
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CCC06S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String plainText = br.readLine();
        String cypher1 = br.readLine();
        String cypher2 = br.readLine();
        HashMap<Character, Character> hashmap = new HashMap<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char c = cypher1.charAt(i);
            if (!hashmap.containsKey(c)) {
                hashmap.put(c,plainText.charAt(i));
            }
        }
        for (char c : cypher2.toCharArray()) {
            if (hashmap.containsKey(c)) {
                output.append(hashmap.get(c));
            } else {
                output.append(".");
            }
        }
        System.out.println(output);
    }
}
