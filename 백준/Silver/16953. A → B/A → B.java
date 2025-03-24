import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        long A = Long.parseLong(input[0]);
        long B = Long.parseLong(input[1]);

        System.out.println(solution(A, B));
    }

    static int solution(long A, long B) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(A, 0));

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (now.num == B) {

                return now.count + 1;
            }

            if (now.num * 2 <= B) {
                queue.offer(new Node(now.num * 2, now.count + 1));
            }

            if (now.num * 10 + 1 <= B) {
                queue.offer(new Node(now.num * 10 + 1, now.count + 1));
            }
        }

        return -1;
    }
}

class Node {

    long num;
    int count;

    public Node(long num, int count) {
        this.num = num;
        this.count = count;
    }
}