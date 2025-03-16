import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static List<Integer>[] lists;
    static int[] arr;
    static boolean[] visited;

    static int root;
    static int remove;
    static int result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        lists = new List[N];
        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(input[i]);

            if (num == -1) {
                root = i;
            } else {

                lists[i].add(num);
                lists[num].add(i);
            }
        }

        remove = Integer.parseInt(br.readLine());

        if (remove == root) {
            System.out.println(0);
            System.exit(0);
        }

        solution(root);
        System.out.println(result);
    }

    static void solution(int num) {

        visited[num] = true;

        int n = 0;

        for (int c : lists[num]) {

            if (c != remove && !visited[c]) {

                n++;
                solution(c);
            }
        }

        if (n == 0) {
            result++;
        }
    }
}

