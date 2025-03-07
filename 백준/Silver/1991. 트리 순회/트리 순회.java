import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static Node[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new Node[N + 1];

        for (int i = 0; i < N; i++) {

            String[] input = br.readLine().split(" ");

            char node = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);

            if (arr[node - 'A'] == null) {

                arr[node - 'A'] = new Node(node);
            }

            if (left != '.') {
                arr[left - 'A'] = new Node(left);
                arr[node - 'A'].left = arr[left - 'A'];
            }

            if (right != '.') {
                arr[right - 'A'] = new Node(right);
                arr[node - 'A'].right = arr[right - 'A'];
            }
        }

        preOrder(arr[0]);
        sb.append("\n");

        inOrder(arr[0]);
        sb.append("\n");

        postOrder(arr[0]);

        System.out.println(sb);
    }

    static void preOrder(Node node) {

        if (node == null) {
            return;
        }

        sb.append(node.node);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);
        sb.append(node.node);
        inOrder(node.right);
    }

    static void postOrder(Node node) {

        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.node);
    }
}

class Node {

    char node;
    Node left;
    Node right;

    public Node(char node) {
        this.node = node;
    }
}