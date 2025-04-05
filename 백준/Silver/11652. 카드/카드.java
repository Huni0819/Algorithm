import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {

            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long min = Long.MAX_VALUE;
        int minCount = 0;
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {

            if (entry.getValue() > minCount) {
                min = entry.getKey();
                minCount = entry.getValue();
            } else if (entry.getValue() == minCount && min > entry.getKey()) {
                min = entry.getKey();
            }
        }

        System.out.println(min);
    }
}
