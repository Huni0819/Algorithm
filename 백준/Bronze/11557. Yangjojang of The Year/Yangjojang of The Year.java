import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {

            int N = Integer.parseInt(br.readLine());
            School[] arr = new School[N];

            for (int i = 0; i < N; i++) {

                String[] input = br.readLine().split(" ");

                String name = input[0];
                int alcohol = Integer.parseInt(input[1]);

                arr[i] = new School(name, alcohol);
            }

            Arrays.sort(arr, Comparator.comparingInt(o -> o.alcohol));

            sb.append(arr[N - 1].name)
                    .append("\n");
        }

        System.out.println(sb);
    }
}

class School {

    String name;
    int alcohol;

    public School(String name, int alcohol) {
        this.name = name;
        this.alcohol = alcohol;
    }
}