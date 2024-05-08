import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int index = 0;

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());

            if (arr[i][0] == k) {
                index = i;
            }
        }

        int result = 1;

        for (int i = 0; i < n; i++) {
            if (i != index) {

                if (arr[i][1] > arr[index][1]) {
                    result++;
                } else if (arr[i][1] == arr[index][1]) {

                    if (arr[i][2] > arr[index][2]) {
                        result++;
                    } else if (arr[i][2] == arr[index][2]) {

                        if (arr[i][3] > arr[index][3]) {
                            result++;
                        }
                    }
                }
            }
        }

        System.out.println(result);

        reader.close();
    }
}