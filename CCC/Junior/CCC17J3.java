
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CCC17J3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st1.nextToken());
        int b = Integer.parseInt(st1.nextToken());
        int c = Integer.parseInt(st2.nextToken());
        int d = Integer.parseInt(st2.nextToken());
        int bat = Integer.parseInt(br.readLine());
        int optimalDist = (Math.abs(c-a)) + (Math.abs(d-b));

        if (optimalDist > bat || (bat - optimalDist) % 2 == 1) {
            System.out.println("N");
        } else {
            System.out.println("Y");
        }
    }
}
