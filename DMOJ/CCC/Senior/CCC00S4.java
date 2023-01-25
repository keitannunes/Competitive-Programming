import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CCC00S4 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<ArrayList<Integer>, Integer> map = new HashMap<>();

        int distance = Integer.parseInt(br.readLine());
        int clubCount = Integer.parseInt(br.readLine());
        Integer[] clubs = new Integer[clubCount];
        for (int i = 0; i < clubCount; i++) {
            clubs[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < clubCount; i++){ //front
            for (int j = clubCount - 1; j >= i; j--){ //back
                System.out.println(Arrays.asList(clubs).subList(i,j+1));
            }
        }




    }
}
