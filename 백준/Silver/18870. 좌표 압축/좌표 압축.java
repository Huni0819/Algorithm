import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] temp = arr.clone();
        Arrays.sort(temp);

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int i = 0; i < N; i++) {

            if (!map.containsKey(temp[i])) {

                map.put(temp[i], count);
                count++;
            }
        }

        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < N; i++) {

            joiner.add(Integer.toString(map.get(arr[i])));
        }

        System.out.println(joiner);
    }
}