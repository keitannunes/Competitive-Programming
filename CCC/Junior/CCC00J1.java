import java.io.*;
import java.util.*;
public class CCC00J1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
       
        System.out.println("Sun Mon Tue Wed Thr Fri Sat");
        for (int i = 0; i < a-1; i++) {
            System.out.print("    ");
        }
        for (int i = 1; i < b+1; i++) {
            
            if ( i == b || ((i + a-1) % 7) == 0 ){
                System.out.printf("%3d\n",i);
            }
            else{
                System.out.printf("%3d ",i);
            }
        }
    }
}
