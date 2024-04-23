import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n;
    static boolean[] visited;
    static String[] arr;
    static List<String> numbers = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        arr = reader.readLine().split(" ");

        visited = new boolean[10];
        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            solution(i, 0, i+"");
        }

        System.out.println(numbers.get(numbers.size() - 1));
        System.out.println(numbers.get(0));

        reader.close();
    }

    private static void solution(int number, int depth, String string) {
        if (depth == n) {
            numbers.add(string);
        } else {
            for (int i = 0; i < 10; i++) {
                if (!visited[i]) {
                    if ((arr[depth].equals(">") && number <= i) || (arr[depth].equals("<") && number >= i)) {
                        continue;
                    }

                    visited[i] = true;
                    solution(i, depth + 1, string + i);
                }
            }
        }
        visited[number] = false;
    }
}