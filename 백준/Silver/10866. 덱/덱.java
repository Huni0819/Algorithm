import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        String[] input;
        Deque deque = new Deque();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            input = reader.readLine().split(" ");

            switch(input[0]) {
                case "push_front":
                    deque.pushFront(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    deque.pushBack(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    builder.append(deque.popFront())
                            .append("\n");
                    break;
                case "pop_back":
                    builder.append(deque.popBack())
                            .append("\n");
                    break;
                case "size":
                    builder.append(deque.size())
                            .append("\n");
                    break;
                case "empty":
                    builder.append(deque.empty())
                            .append("\n");
                    break;
                case "front":
                    builder.append(deque.getFront())
                            .append("\n");
                    break;
                case "back":
                    builder.append(deque.getBack())
                            .append("\n");
                    break;
            }
        }

        System.out.println(builder);
    }
}

class Deque {

    List<Integer> list;

    public Deque() {
        this.list = new ArrayList<>();
    }

    public void pushFront(int x) {
        list.add(0, x);
    }

    public void pushBack(int x) {
        list.add(x);
    }

    public int popFront() {
        if (isEmpty()) {
            return -1;
        }

        return list.remove(0);
    }

    public int popBack() {
        if (isEmpty()) {
            return -1;
        }

        return list.remove(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    public int empty() {
        return size() == 0 ? 1 : 0;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return list.get(0);
    }

    public int getBack() {
        if (isEmpty()) {
            return -1;
        }

        return list.get(list.size() - 1);
    }

    private boolean isEmpty() {
        return empty() == 1;
    }
}