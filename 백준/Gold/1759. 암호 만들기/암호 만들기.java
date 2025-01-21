import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static int L;
    static int C;

    static String[] arr;
    static boolean[] visited = new boolean[26];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        arr = br.readLine().split(" ");

        Arrays.sort(arr, Comparator.comparingInt(o -> o.charAt(0)));

        solution(0, 0);

        System.out.println(sb);
    }

    static void solution(int dep, int idx) {

        if (dep == L) {

            if (!vowelCheck() || !consonantCheck()) {
                return;
            }

            for (int i = 0; i < visited.length; i++) {

                if (visited[i]) {
                    sb.append(Character.toChars(i + 'a'));
                }
            }

            sb.append("\n");
            return;
        }

        for (int i = idx; i < arr.length; i++) {

            if (!visited[arr[i].charAt(0) - 'a']) {

                visited[arr[i].charAt(0) - 'a'] = true;
                solution(dep + 1, i);
                visited[arr[i].charAt(0) - 'a'] = false;
            }
        }
    }

    static boolean vowelCheck() {

        return visited['a' - 'a'] || visited['e' - 'a'] || visited['i' - 'a'] || visited['o' - 'a'] || visited['u' - 'a'];
    }

    static boolean consonantCheck() {

        int count = 0;

        for (int i = 0; i < 26; i++) {

            if (i == 'a' - 'a' || i == 'e' - 'a' || i == 'i' - 'a' || i == 'o' - 'a' || i == 'u' - 'a') {
                continue;
            }

            if (visited[i]) {
                count++;
            }
        }

        return count >= 2;
    }
}