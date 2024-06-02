import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        int count = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = reader.readLine();

            if (map.containsKey(name)) {
                map.put(name, map.get(name));
            } else {
                map.put(name, 1);
            }
        }

        int result = map.size();

        switch (game) {
            case "F":
                result /= 2;
                break;
            case "O":
                result /= 3;
                break;
            default:
        }

        System.out.println(result);
    }
}