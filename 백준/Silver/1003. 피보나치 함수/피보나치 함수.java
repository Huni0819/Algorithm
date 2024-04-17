import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder builder = new StringBuilder();
    static int[] zeroArr;
    static int[] oneArr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            zeroArr = new int[n+1];
            oneArr = new int[n+1];
            solution(n);
        }

        System.out.println(builder);
        reader.close();
    }

    private static void solution(int num) {
        if (num == 0) {
            builder.append(1).append(" ").append(0).append("\n");
            return;
        } else if (num == 1) {
            builder.append(0).append(" ").append(1).append("\n");
            return;
        }

        zeroArr[0] = oneArr[1] = 1;
        zeroArr[1] = oneArr[0] = 0;

        for (int i = 2; i <= num; i++) {
            zeroArr[i] = zeroArr[i-1] + zeroArr[i-2];
            oneArr[i] = oneArr[i-1] + oneArr[i-2];
        }

        builder.append(zeroArr[num]).append(" ").append(oneArr[num]).append("\n");
    }
}