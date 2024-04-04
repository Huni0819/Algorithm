import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        int n = Integer.valueOf(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.valueOf(st.nextToken());

            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }

        int m = Integer.valueOf(reader.readLine());

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.valueOf(st.nextToken());

            builder.append(map.containsKey(num) ? map.get(num) : 0).append(" ");
        }

        System.out.println(builder.toString().trim());
    }
}
