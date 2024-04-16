import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        solution(min, max);

        reader.close();
    }

    public static void solution(long min, long max) {

        int size = (int) (max - min);

        boolean[] arr = new boolean[size + 1];

        for (long i = 2; i <= Math.sqrt(max); i++) {
            long pow = i * i;

            long tmp = min / pow;

            if (min % pow != 0) {
                tmp++;
            }
            
            for (long j = tmp; j * pow <= max; j++) {
                arr[(int) (j * pow - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i <= size; i++) {
            if (!arr[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}