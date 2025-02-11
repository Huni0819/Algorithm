import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {

            arr[i] = br.readLine();
        }

        Set<String> set = new HashSet<>();

        for (int i = 0; i < M; i++) {
            set.add(br.readLine());
        }

        int count = 0;
        List<String> result = new ArrayList<>();
        for (String name : arr) {

            if (set.contains(name)) {
                count++;
                result.add(name);
            }
        }

        Collections.sort(result);

        sb.append(count)
                .append("\n");

        for (String name : result) {

            sb.append(name)
                    .append("\n");
        }

        System.out.println(sb);

    }
}