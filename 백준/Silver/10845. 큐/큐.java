import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        String[] input;
        Queue queue = new Queue();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            input = reader.readLine().split(" ");

            switch (input[0]) {
                case "push":
                    queue.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    builder.append(queue.pop())
                            .append("\n");
                    break;
                case "size":
                    builder.append(queue.size())
                            .append("\n");
                    break;
                case "empty":
                    builder.append(queue.empty())
                            .append("\n");
                    break;
                case "front":
                    builder.append(queue.front())
                            .append("\n");
                    break;
                case "back":
                    builder.append(queue.back())
                            .append("\n");
                    break;
            }
        }

        System.out.println(builder);
    }
}

class Queue {

    List<Integer> list;

    public Queue() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        if (list.size() == 0) {
            return -1;
        }

        return list.remove(0);
    }

    public int size() {
        return list.size();
    }

    public int empty() {
        return list.size() == 0 ? 1 : 0;
    }

    public int front() {
        if (list.size() == 0) {
            return -1;
        }

        return list.get(0);
    }

    public int back() {
        if (list.size() == 0) {
            return -1;
        }

        return list.get(list.size()-1);
    }
}