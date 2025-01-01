import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr[0].length(); i++) {

            boolean flag = true;
            for (int j = 1; j < arr.length; j++) {

                if (arr[0].charAt(i) != arr[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }

            builder.append(flag ? arr[0].charAt(i) : "?");
        }

        System.out.println(builder);
    }
}