import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[] owned = new boolean[n+1];

        int q = Integer.parseInt(st.nextToken());

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int x = Integer.parseInt(reader.readLine());

            int num = x;
            int check = 0;
            while (num > 0) {

                if (owned[num]) {
                    check = num;
                }

                num /= 2;
            }

            if (check != 0) {
                builder.append(check).append("\n");
                continue;
            }

            owned[x] = true;
            builder.append(0).append("\n");
        }

        System.out.println(builder);
    }
}