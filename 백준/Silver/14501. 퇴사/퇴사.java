import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;

    static int max = 0;

    static Consult[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        arr = new Consult[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            arr[i] = new Consult(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n; i++) {
            if (i + arr[i].day <= n) {
                for (int k = 0; k < arr[i].day; k++) {
                    visited[i+k] = true;
                }
                solution(i, arr[i].amount);
                for (int k = 0; k < arr[i].day; k++) {
                    visited[i+k] = false;
                }
            }
        }

        System.out.println(max);
    }

    private static void solution(int index, int sum) {

        max = Math.max(max, sum);

        for (int i = index; i < n; i++) {
            if (!visited[i]) {
                if (i + arr[i].day <= n) {
                    for (int k = 0; k < arr[i].day; k++) {
                        visited[i+k] = true;
                    }
                    solution(i, sum + arr[i].amount);
                    for (int k = 0; k < arr[i].day; k++) {
                        visited[i+k] = false;
                    }

                }
            }
        }
    }
}

class Consult {

    int day;
    int amount;

    public Consult(int day, int amount) {
        this.day = day;
        this.amount = amount;
    }
}