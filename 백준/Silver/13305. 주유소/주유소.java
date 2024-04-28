import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        solution.solution();
    }
}

class Solution {

    private int n;
    private int[] city;
    private int[] road;


    public void solution() throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        road = new int[n-1];
        city = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n-1; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0L;
        long min = city[0];

        for (int i = 0; i < n -1; i++) {
            if (city[i] < min) {
                min = city[i];
            }

            sum += (min * road[i]);
        }

        System.out.println(sum);

        reader.close();
    }

}