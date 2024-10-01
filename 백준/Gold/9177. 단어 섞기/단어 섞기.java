import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[] one;
    static char[] two;
    static char[] three;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(reader.readLine());

        for (int n = 0; n < N; n++) {
            builder.append("Data set ")
                    .append(n+1)
                    .append(": ");

            String[] input = reader.readLine().split(" ");

            one = input[0].toCharArray();
            two = input[1].toCharArray();
            three = input[2].toCharArray();

            builder.append(bfs() ? "yes" : "no")
                    .append("\n");
        }

        System.out.println(builder);

    }

    static boolean bfs() {
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(0, 0 ,0));

        boolean[][] visited = new boolean[one.length+1][two.length+1];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Word now = queue.poll();

            if (now.index3 == three.length) {
                return true;
            }

            if (now.index1 < one.length && !visited[now.index1 + 1][now.index2] && one[now.index1] == three[now.index3]) {
                queue.offer(new Word(now.index1 + 1, now.index2, now.index3 + 1));
                visited[now.index1 + 1][now.index2] = true;
            }

            if (now.index2 < two.length && !visited[now.index1][now.index2+1] && two[now.index2] == three[now.index3]) {
                queue.offer(new Word(now.index1, now.index2 + 1, now.index3 + 1));
                visited[now.index1][now.index2 + 1] = true;
            }
        }

        return false;
    }
}

class Word {

    int index1;
    int index2;
    int index3;

    public Word(int index1, int index2, int index3) {
        this.index1 = index1;
        this.index2 = index2;
        this.index3 = index3;
    }
}