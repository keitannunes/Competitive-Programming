import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CCC04S3 {
    static int[][] grid = new int[10][9];

    public static int getVal(String s) {
        char[] chars = s.toCharArray();
        return grid[chars[0] - 65][chars[1] - 49];
    }

    public static void setVal(String s, int val) {
        char[] chars = s.toCharArray();
        grid[chars[0] - 65][chars[1] - 49] = val;
    }

    public static String coordsToCell(int x, int y) {
        return Character.toString(x + 65) + Character.toString(y + 49);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int[] a : grid) {
            Arrays.fill(a,-1);
        }
        ArrayDeque<String> reCalculateQueue = new ArrayDeque<>();
        Map<String,ArrayList<String>> graph = new HashMap<>(); //Cell dependencies
        Map<String,Boolean> isCalculated = new HashMap<>();
        Map<String,String> cellStrings = new HashMap<>();
        for (int i = 0; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                String cell = coordsToCell(i,j);
                String cellString = st.nextToken();
                String[] split = cellString.split("\\+");
                int sum = 0;
                boolean bad = false;
                for (String s : split) {
                    try {
                        sum += Integer.parseInt(s);
                    } catch (NumberFormatException err){ //if it's not an integer
                        if (!graph.containsKey(s)) {
                            graph.put(s, new ArrayList<>());
                        }
                        graph.get(s).add(cell); //add current cell to the dependency list of the current split str
                        int val = getVal(s);
                        if (val == -1) {
                            bad = true;
                        } else {
                            sum += val;
                        }
                    }
                }
                if (!bad) {
                    if (graph.get(cell) != null) {
                        for (String dependencies : graph.get(cell)) {
                            if (isCalculated.get(dependencies) == null) {
                                reCalculateQueue.offer(dependencies);
                            }
                        }
                    }
                    isCalculated.put(cell,true);
                    setVal(cell,sum);
                } else {
                    cellStrings.put(cell,cellString);
                }
            }
        }
        while (!reCalculateQueue.isEmpty()) {
            String current = reCalculateQueue.poll();
            int sum = 0;
            for (String s : cellStrings.get(current).split("\\+")) {
                int val = getVal(s);
                if (val == -1) {
                    sum = -1;
                    break;
                } else {
                    sum += val;
                }
            }
            if (sum != -1) {
                setVal(current,sum);
                isCalculated.put(current,true);
                if (graph.get(current) != null) {
                    for (String dependencies : graph.get(current)) {
                        if (isCalculated.get(dependencies) == null) {
                            reCalculateQueue.offer(dependencies);
                        }
                    }
                }
            }
        }


        for (int[] a : grid) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                if (a[i] != -1)
                    line.append(a[i]).append(" ");
                else line.append("*").append(" ");
            }
            if (a[8] != -1)
                line.append(a[8]).append(" ");
            else line.append("*").append(" ");
            System.out.println(line);
        }
    }
}
