import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);
        int T = Integer.parseInt(input[3]);
        int R = Integer.parseInt(input[4]);

        int count = 0;
        int time = 0;
        int now = m;
        
        if (M - m < T) {

            System.out.println(-1);
            System.exit(0);
        }
        while (true) {

            if (count >= N) {
                break;
            }

            if (now + T <= M) {

                now += T;
                count++;
            } else {

                now = Math.max(m, now - R);
            }

            time++;
        }

        System.out.println(time);
    }
}