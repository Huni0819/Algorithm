import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] min = new int[3];
        int[] max = new int[3];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        min[0] = max[0] = Integer.parseInt(st.nextToken());
        min[1] = max[1] = Integer.parseInt(st.nextToken());
        min[2] = max[2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            int min0 = Math.min(min[0], min[1]) + x;
            int min1 = Math.min(min[0], Math.min(min[1], min[2])) + y;
            int min2 = Math.min(min[1], min[2]) + z;

            min[0] = min0;
            min[1] = min1;
            min[2] = min2;

            int max0 = Math.max(max[0], max[1]) + x;
            int max1 = Math.max(max[0], Math.max(max[1], max[2])) + y;
            int max2 = Math.max(max[1], max[2]) + z;

            max[0] = max0;
            max[1] = max1;
            max[2] = max2;

        }

        System.out.println(Math.max(max[0], Math.max(max[1], max[2])) + " " + Math.min(min[0], Math.min(min[1], min[2])));
    }
}