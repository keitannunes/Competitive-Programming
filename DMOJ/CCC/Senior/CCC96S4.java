import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class CCC96S4 {
    static HashMap<Character, Integer> map;

    public static void initMap() {
        map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

    }

    public static int romanToInt(String str) {
        int sum = 0;
        int i = 0;
        while (i < str.length()) {
            int a = map.get(str.charAt(i));
            int b = -1;
            if (i + 1< str.length()) {
                b = map.get(str.charAt(i + 1));
            }
            if (b > a) {
                sum += b - a;
                i++;
            } else {
                sum += a;
            }
            i++;
        }
        return sum;
    }

    public static void intToRoman(int num) {
        while (num != 0) {
            if (num >= 1000) {
                num -= 1000;
                System.out.print('M');
            } else if (num >= 900) {
                num -= 900;
                System.out.print('C');
                System.out.print('M');
            } else if (num >= 500) {
                num -= 500;
                System.out.print('D');
            } else if (num >= 400) {
                num -= 400;
                System.out.print('C');
                System.out.print('D');
            } else if (num >= 100) {
                num -= 100;
                System.out.print('C');
            } else if (num >= 90) {
                num -= 90;
                System.out.print('X');
                System.out.print('C');
            } else if (num >= 50) {
                num -= 50;
                System.out.print('L');
            } else if (num >= 40) {
                num -= 40;
                System.out.print('X');
                System.out.print('L');
            } else if (num >= 10) {
                num -= 10;
                System.out.print('X');
            } else if (num >= 9) {
                num -= 9;
                System.out.print('I');
                System.out.print('X');
            } else if (num >= 5) {
                num -= 5;
                System.out.print('V');
            } else if (num >= 4) {
                num -= 4;
                System.out.print('I');
                System.out.print('V');
            } else {
                num--;
                System.out.print('I');
            }
        }
    }

    public static void main(String[] args) throws IOException {
        initMap();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringBuilder input = new StringBuilder(br.readLine());
            String[] nums = input.deleteCharAt(input.length() - 1).toString().split("\\+");
            int ans = romanToInt(nums[0]) + romanToInt(nums[1]);
            System.out.print(input);
            System.out.print('=');
            if (ans > 1000) {
                System.out.println("CONCORDIA CUM VERITATE");
            } else {
                intToRoman(ans);
                System.out.print('\n');
            }
        }

    }
}
