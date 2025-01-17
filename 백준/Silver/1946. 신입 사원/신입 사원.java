import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            int N = Integer.parseInt(br.readLine());

            Employee[] arr = new Employee[N];
            for (int i = 0; i < N; i++) {

                String[] input = br.readLine().split(" ");

                arr[i] = new Employee(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            }

            Arrays.sort(arr, Comparator.comparingInt((o -> o.report)));

            int result = 1;
            int min = arr[0].interview;

            for (int i = 1; i < N; i++) {

                if (arr[i].interview < min) {

                    result++;
                    min = arr[i].interview;
                }
            }

            sb.append(result)
                    .append("\n");
        }

        System.out.println(sb);
    }
}

class Employee {

    int report;
    int interview;

    public Employee(int report, int interview) {

        this.report = report;
        this.interview = interview;
    }
}