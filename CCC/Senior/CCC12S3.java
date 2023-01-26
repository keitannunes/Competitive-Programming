
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CCC12S3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int largestFreq = 0;
        int maxInLargest = 1000;
        int minInLargest = 1;
        int maxInSecondLargest = 1000;
        int minInSecondLargest = 1;
        int secondLargestFreq = 0;
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(br.readLine());
            int freq;
            if (!map.containsKey(data)) {
                map.put(data, 1);
                freq = 1;
            } else {
                freq = map.get(data) + 1;
                map.put(data, freq);
            }
            if (freq > largestFreq) {
                if (maxInLargest != data) {
                    secondLargestFreq = largestFreq;
                    maxInSecondLargest = maxInLargest;
                    minInSecondLargest = minInLargest;
                }
                largestFreq = freq;
                maxInLargest = data;
                minInLargest = data;
            } else if (freq == largestFreq) {
                if (data > maxInLargest)
                    maxInLargest = data;
                else if (data < minInLargest)
                    minInLargest = data;
            } else if (freq > secondLargestFreq) {
                secondLargestFreq = freq;
                maxInSecondLargest = data;
                minInSecondLargest = data;
            } else if (freq == secondLargestFreq) {
                if (data > maxInSecondLargest)
                    maxInSecondLargest = data;
                else if (data < minInSecondLargest)
                    minInSecondLargest = data;
            }
        }
        if (maxInLargest == minInLargest) {
            int a = Math.abs(maxInLargest - minInSecondLargest);
            int b = Math.abs(maxInSecondLargest - minInLargest);
            System.out.println(Math.max(a, b));
        } else {
            System.out.println(Math.abs(maxInLargest - minInLargest));
        }
    }
}


