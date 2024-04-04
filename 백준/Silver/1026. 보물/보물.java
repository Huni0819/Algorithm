import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int n = Integer.valueOf(reader.readLine());
        int[] arrayA = input(n);
        int[] arrayB = input(n);

        Arrays.sort(arrayA);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int max = 0;

            for (int k = 0; k < n; k++) {
                if (!map.containsKey(k)) {
                    max = k;
                    break;
                }
            }

            for (int j = 0; j < n; j++) {
                if (!map.containsKey(j)) {
                    max = arrayB[j] >= arrayB[max] ? j : max;
                }
            }

            map.put(max, arrayA[i] * arrayB[max]);
        }

        int sum = 0;
        for (Integer value : map.values()) {
            sum += value;
        }

        System.out.println(sum);
    }


    private static int[] input(int n) throws Exception {
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.valueOf(st.nextToken());
        }

        return array;
    }
}