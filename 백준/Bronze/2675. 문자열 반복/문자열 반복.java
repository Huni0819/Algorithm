import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int count = Integer.parseInt(st.nextToken());

            String line = st.nextToken();

            for (int j = 0; j < line.length(); j++) {
                for (int k = 0; k < count; k++) {
                    sb.append(line.charAt(j));
                }
            }

            System.out.println(sb);
        }
    }
}