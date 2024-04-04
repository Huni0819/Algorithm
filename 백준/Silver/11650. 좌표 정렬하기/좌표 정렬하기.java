import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int n = Integer.valueOf(reader.readLine());

        int[][] array = new int[n][2];

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(reader.readLine());

            array[i][0] = Integer.valueOf(st.nextToken());
            array[i][1] = Integer.valueOf(st.nextToken());
        }

        List<int[]> list = Arrays.stream(array)
                .sorted((o1, o2) -> {
                    if (o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    }

                    return o1[0] - o2[0];
                }).collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }

    }
}