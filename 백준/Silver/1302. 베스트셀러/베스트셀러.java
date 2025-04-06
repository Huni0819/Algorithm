import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {

            String book = br.readLine();

            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String book = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (max < entry.getValue()) {
                book = entry.getKey();
                max = entry.getValue();
            } else if (max == entry.getValue()) {

                if (book.compareTo(entry.getKey()) > 0) {
                    book = entry.getKey();
                }
            }
        }

        System.out.println(book);
    }
}