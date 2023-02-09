import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int quarters = Integer.parseInt(br.readLine());
        int onePlays = Integer.parseInt(br.readLine());
        int twoPlays = Integer.parseInt(br.readLine());
        int threePlays = Integer.parseInt(br.readLine());
        int counter = 0;
        while (true) {
            if (quarters != 0) {
                onePlays++;
                counter++;
                quarters--;
                if (onePlays % 35 == 0) {
                    quarters += 30;
                }
            } else {
                break;
            }
            if (quarters != 0) {
                twoPlays++;
                counter++;
                quarters--;
                if (twoPlays % 100 == 0) {
                    quarters += 60;
                }
            } else {
                break;
            }
            if (quarters != 0) {
                threePlays++;
                counter++;
                quarters--;
                if (threePlays % 10 == 0) {
                    quarters += 9;
                }
            } else {
                break;
            }
        }
        System.out.printf("Martha plays %d times before going broke.", counter);
    }
}
