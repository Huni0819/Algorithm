import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int sumY = 0;
        int sumM = 0;

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            sumY += 10 * (num / 30 + 1);
            sumM += 15 * (num / 60 + 1);
        }

        StringBuilder builder = new StringBuilder();
        if (sumY <= sumM) {
            builder.append("Y ");
        }

        if (sumM <= sumY) {
            builder.append("M ");
        }

        builder.append(Math.min(sumM, sumY));
        System.out.println(builder);

        reader.close();

    }
}