import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int P;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        P = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= P; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int T = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];

            for (int j = 0; j < 20; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(T + " " + solution(arr));
        }

        reader.close();
    }

    private static int solution(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}