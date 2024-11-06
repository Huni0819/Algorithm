import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        boolean[] arr = new boolean[N+1];

        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {

            for (int j = i * i; j <= N; j += i) {
                arr[j] = true;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if(!arr[i]) {
                builder.append(i)
                    .append("\n");
            }
        }

        System.out.print(builder);
    }
}