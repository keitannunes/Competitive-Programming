
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC16J3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int longest = 0;
        int i = 0;
        do {
            char currentChar = input.charAt(i);
            if (input.lastIndexOf(currentChar) != i) {
                for (int j = input.lastIndexOf(currentChar); j > i + longest; j--) {
                    if (input.charAt(j) == currentChar) {
                        String substring = input.substring(i,j+1);
                        StringBuilder reversed = new StringBuilder(substring);
                        reversed.reverse();
                        if (substring.equals(reversed.toString())) {
                            longest = substring.length();
                            break;
                        }
                    }
                }
            }
            i++;
        } while (i < input.length() - longest);
        System.out.println(longest);
    }
}
