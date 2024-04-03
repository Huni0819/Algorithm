import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Set<Integer> card = new HashSet<>();

    public static void main(String[] args) throws Exception {

        int n = Integer.valueOf(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            card.add(Integer.valueOf(st.nextToken()));
        }

        int m = Integer.valueOf(reader.readLine());

        StringBuilder builder = new StringBuilder();
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            int check = card.contains(Integer.valueOf(st.nextToken())) ? 1 : 0;

            builder.append(check).append(" ");
        }

        writer.write(builder.toString().trim());
        writer.flush();

        reader.close();
        writer.close();
    }

}