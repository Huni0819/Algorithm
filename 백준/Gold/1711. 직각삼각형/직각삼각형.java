import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static int N;
    static long[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        arr = new long[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");

            arr[i][0] = Long.parseLong(input[0]);
            arr[i][1] = Long.parseLong(input[1]);
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {

                    long ab = (arr[i][0] - arr[j][0]) * (arr[i][0] - arr[j][0]) + (arr[i][1] - arr[j][1]) * (arr[i][1] - arr[j][1]);
                    long bc = (arr[j][0] - arr[k][0]) * (arr[j][0] - arr[k][0]) + (arr[j][1] - arr[k][1]) * (arr[j][1] - arr[k][1]);
                    long ac = (arr[i][0] - arr[k][0]) * (arr[i][0] - arr[k][0]) + (arr[i][1] - arr[k][1]) * (arr[i][1] - arr[k][1]);

                    if (ab + bc == ac || bc + ac == ab || ab + ac == bc) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}