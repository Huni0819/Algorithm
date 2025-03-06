import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int N;
    static int M;

    static List<City>[] lists;
    static long[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        lists = new List[N + 1];
        arr = new long[N + 1];

        Arrays.fill(arr, Long.MAX_VALUE);

        for (int i = 1; i <= N; i++) {

            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {

            input = br.readLine().split(" ");

            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);

            lists[A].add(new City(B, C));

        }

        StringBuilder sb = new StringBuilder();

        if (solution()) {
            System.out.println(-1);
            return;
        }

        for (int i = 2; i <= N; i++) {

            sb.append(arr[i] == Long.MAX_VALUE ? "-1" : arr[i])
                    .append("\n");
        }

        System.out.println(sb);
    }

    static boolean solution() {

        arr[1] = 0;
        boolean flag = false;

        for (int i = 1; i < N; i++) {

            flag = false;

            for (int j = 1; j <= N; j++) {

                for (City c : lists[j]) {

                    if (arr[j] == Long.MAX_VALUE) {
                        break;
                    }

                    if (arr[c.e] > arr[j] + c.w) {
                        arr[c.e] = arr[j] + c.w;
                        flag = true;
                    }
                }
            }

            if (!flag) {
                break;
            }
        }

        if (flag) {

            for (int i = 1; i <= N; i++) {

                for (City c : lists[i]) {

                    if (arr[i] == Long.MAX_VALUE) {
                        break;
                    }

                    if (arr[c.e] > arr[i] + c.w) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

class City {

    int e;
    int w;

    public City(int e, int w) {
        this.e = e;
        this.w = w;
    }
}