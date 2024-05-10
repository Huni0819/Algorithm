import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        if (n == m) {
            System.out.println(0);
            return;
        }
        

        System.out.println(Math.abs(n - m) - 1);

        StringBuilder builder = new StringBuilder();
        for (int i = Math.min(n, m)+1; i < Math.max(n, m); i++) {
            builder.append(i).append(" ");
        }

        System.out.println(builder);
    }
}