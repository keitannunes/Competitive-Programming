
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CCC12S2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int decimal = 0;
        for (int i = 0; i < input.length() - 2; i+=2) {
            int pair = Integer.parseInt(Character.toString(input.charAt(i))) * map.get(input.charAt(i+1));
            if (map.get(input.charAt(i+1)) < map.get(input.charAt(i+3))) {
                decimal -= pair;
            } else {
                decimal += pair;
            }
        }
        decimal += Integer.parseInt(Character.toString(input.charAt(input.length()-2)))
                * map.get(input.charAt(input.length()-1));
        System.out.println(decimal);
    }
}
