import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        solution.input();
        solution.solution();
    }
}

class Solution {

    private static int maxIndex = 0;

    private int k;
    private int n;
    private String[] arr;


    public void input() throws Exception {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new String[k];

        for (int i = 0; i < k; i++) {
            arr[i] = reader.readLine();
        }

        reader.close();
    }

    public void solution() {
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o2.compareTo(o1);
            }

            return (o2 + o1).compareTo(o1 + o2);
        });

        for (int i = 0; i < k; i++) {
            maxIndex = Integer.parseInt(arr[i]) > Integer.parseInt(arr[maxIndex]) ? i : maxIndex;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < k; i++) {
            builder.append(arr[i]);

            if (i == maxIndex) {
                for (int j = 0; j < n - k; j++) {
                    builder.append(arr[i]);
                }
            }
        }

        System.out.println(builder);
    }
}