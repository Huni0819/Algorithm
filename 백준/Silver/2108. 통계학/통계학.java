import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[8_001];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int mid = 10_000;
        int mode = 10_000;

        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(br.readLine());

            sum += num;
            arr[num + 4_000]++;

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int count = 0;
        int mode_max = 0;

        boolean flag = false;

        for (int i = min + 4_000; i <= max + 4_000; i++) {

            if (arr[i] > 0) {

                if (count < (N + 1) / 2) {

                    count += arr[i];
                    mid = i - 4_000;
                }

                if (mode_max < arr[i]) {

                    mode_max = arr[i];
                    mode = i - 4_000;
                    flag = true;
                } else if (mode_max == arr[i] && flag == true) {
                    
                    mode = i - 4_000;
                    flag = false;
                }
            }
        }

        sb.append((int) Math.round((double) sum / N))
                .append("\n")
                .append(mid)
                .append("\n")
                .append(mode)
                .append("\n")
                .append(max - min);

        System.out.println(sb);



    }
}