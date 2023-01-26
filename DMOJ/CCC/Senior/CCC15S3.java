import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class CCC15S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        TreeSet<Integer> gates = new TreeSet<>();
        for (int i = 1; i < G + 1; i++) {
            gates.add(i);
        }
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++){
            int j = Integer.parseInt(br.readLine());
            try {
                gates.remove(gates.floor(j));
            } catch (NullPointerException err) {
                break;
            }
           count++;
        }
        System.out.println(count);
    }
}
