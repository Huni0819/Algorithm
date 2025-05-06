import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][];

        for (int i = 0; i < 5; i++) {

            arr[i] = br.readLine().toCharArray();
        }

        StringBuilder sb = new StringBuilder();

        int idx = 0;
        while (idx < 15) {

            for (int i = 0; i < 5; i++) {

                if (idx < arr[i].length) {

                    sb.append(arr[i][idx]);
                }
            }

            idx++;
        }

        System.out.println(sb);
    }
}