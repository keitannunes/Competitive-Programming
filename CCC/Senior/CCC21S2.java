import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CCC21S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] rows =  new int[M];
        int[] columns = new int[N];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int num = Integer.parseInt(st.nextToken()) - 1;
            if (s.equals("R")) {
                rows[num]++;
            } else {
                columns[num]++;
            }
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                count += (rows[i] + columns[j]) % 2 == 0 ? 0 : 1;
            }
        }
        System.out.println(count);
    }
}
