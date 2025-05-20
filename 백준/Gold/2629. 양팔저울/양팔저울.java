import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int M;
    static int[] weights;
    static int[] beads;

    static boolean[] check = new boolean[15_001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        weights = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        M = Integer.parseInt(br.readLine());
        beads = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution();

        for (int bead : beads) {

            sb.append(bead > 15_000 || !check[bead] ? "N " : "Y ");
        }

        System.out.println(sb);
    }

    static void solution() {

        List<Integer> list = new ArrayList<>();
        for (int weight : weights) {

            list.clear();

            if (!check[weight]) {

                list.add(weight);
            }

            for (int i = 0; i <= 15_000; i++) {

                if (check[i]) {

                    if (i + weight <= 15_000) {

                        list.add(i + weight);
                    }

                    list.add(Math.abs(i - weight));
                }
            }

            for (int num : list) {

                check[num] = true;
            }
        }
    }
}