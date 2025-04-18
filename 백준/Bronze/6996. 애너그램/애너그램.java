import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            String[] input =  br.readLine().split(" ");

            int[] arr1 = new int['z' - 'a' + 1];
            int[] arr2 = new int['z' - 'a' + 1];

            for (int j = 0; j < input[0].length(); j++) {

                arr1[input[0].charAt(j) - 'a']++;
            }

            for (int j = 0; j < input[1].length(); j++) {

                arr2[input[1].charAt(j) - 'a']++;
            }

            boolean flag = true;
            for (int j = 0; j < 'z' - 'a' + 1; j++) {

                if (arr1[j] != arr2[j]) {
                    flag = false;
                    break;
                }
            }

            sb.append(input[0])
                    .append(" & ")
                    .append(input[1])
                    .append(" are ")
                    .append(!flag ? "NOT " : "")
                    .append("anagrams.")
                    .append("\n");
        }

        System.out.println(sb);
    }
}