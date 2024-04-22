import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int[] arr;
    static int count;

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution());

        br.close();
    }

    private static int solution() {
        int num = k;

        for (int i = n-1; i >= 0; i--) {
            if (num == 0) {
                break;
            }
            count += num / arr[i];
            num = num % arr[i];
        }

        return count;
    }
}