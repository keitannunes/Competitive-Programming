
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CCC21S3 {
    private static int N;
    private static int[] P, W, D;

    public static long getTimeSum(long x) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (Math.abs(x - P[i]) - D[i] > 0) {
                sum += (Math.abs(x - P[i]) - D[i])*W[i];
            }
        }
        return sum;
    }

    public static long getTimeSum2(long x) {
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if (x < P[i] - D[i]) {
                sum += W[i] * (P[i] - D[i] - x);
            } else if (x > P[i] + D[i]) {
                sum += W[i] * (x - P[i] - D[i]);
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N]; //Pos
        W = new int[N]; //Speed
        D = new int[N]; //Hearing distance
        int min = 1_000_000_000;
        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            P[i] = p;
            W[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
            if (p > max) {
                max = p;
            }
            if (p < min) {
                min = p;
            }
        }
        for (int i =0; i < 30; i++) {
            System.out.printf("%d,%d\n",getTimeSum(i),getTimeSum2(i));
        }
        long cTime = 0;
        while (min < max) {
            int C = (min + max) / 2;
            cTime = getTimeSum2(C);
            long forwardStepTime = getTimeSum2(C + 1);
            long backwardStepTime = getTimeSum2(C - 1);
            if (cTime <= forwardStepTime && cTime <= backwardStepTime) {
                break;
            } else if (cTime > backwardStepTime) {
                max = C + 1;
            } else {
                min = C - 1;
            }
        }
        System.out.println(cTime);
    }
}
