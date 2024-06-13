import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;

    static int[] arr;


    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(reader.readLine());

        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // b -> 총 감독관이 감독할 수 있는 사람 수
        // c -> 부 감독관이 감독할 수 있는 사람 수

        // 각 시험장에 총 감독관을 한명 씩 넣어두고
        // 나머지 인원은 부 감독관으로 채움

        long count = n;

        for (int i = 0; i < n; i++) {
            arr[i] -= b;

            if (arr[i] > 0) {
                count += arr[i] / c;

                if (arr[i] % c != 0) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}