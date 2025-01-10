import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {

                String[] input = br.readLine().split(" ");

                int n = Integer.parseInt(input[1]);

                if (input[0].equals("I")) { // 데이터 삽입

                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else { // 데이터 삭제

                    if (map.size() == 0) {
                        continue;
                    }

                    int key = n == 1 ? map.lastKey() : map.firstKey();

                    if (map.get(key) == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
                }
            }

            sb.append(map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey())
                    .append("\n");
        }

        System.out.print(sb);
    }
}

