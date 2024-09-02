import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");

            int[] arr1 = sum(input[0]);
            int[] arr2 = sum(input[1]);

            builder.append(check(arr1, arr2) ? "Possible" : "Impossible")
                    .append("\n");
        }

        System.out.println(builder);
    }

    public static int[] sum(String str) {
        int[] arr = new int['z' - 'a' + 1];

        for (int i = 0; i < str.length(); i++) {

            arr[str.charAt(i) - 'a']++;
        }

        return arr;
    }

    public static boolean check(int[] arr1, int[] arr2) {

        for (int i = 0; i < arr1.length; i++) {

            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}