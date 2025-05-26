import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {

    static Node node;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = new Node(Integer.parseInt(br.readLine()));
        String line;

        while ((line = br.readLine()) != null) {


            insert(node, Integer.parseInt(line));
        }

        solution(node);
        System.out.println(sb);
    }

    static void solution(Node node) {

        if (Objects.isNull(node)) {

            return;
        }

        solution(node.left);
        solution(node.right);
        sb.append(node.num)
                .append("\n");
    }

    static void insert(Node node, int num) {

        if (num < node.num) {

            if (Objects.isNull(node.left)) {

                node.left = new Node(num);
                return;
            }

            insert(node.left, num);
        } else {

            if (Objects.isNull(node.right)) {

                node.right = new Node(num);
                return;
            }

            insert(node.right, num);
        }
    }


}

class Node {

    int num;
    Node left;
    Node right;

    public Node(int num) {
        this.num = num;
    }
}