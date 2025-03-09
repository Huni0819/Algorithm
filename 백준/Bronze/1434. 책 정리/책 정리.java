import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[] arr = new int[N];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(input[i]);
        }

        int[] book = new int[M];

        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {

            book[i] = Integer.parseInt(input[i]);
        }

        int num = 0;
        for (int i = 0; i < M; i++) {

            while (true) {

                if (arr[num] < book[i]) {
                    num++;
                } else {
                    arr[num] -= book[i];
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}