import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();

        Stack stack = new Stack();
        String[] input;
        for (int i = 0; i < N; i++) {
            input = reader.readLine().split(" ");

            switch(input[0]) {
                case "push":
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    builder.append(stack.pop()).append("\n");
                    break;
                case "size":
                    builder.append(stack.size()).append("\n");
                    break;
                case "empty":
                    builder.append(stack.empty()).append("\n");
                    break;
                case "top":
                    builder.append(stack.top()).append("\n");
            }
        }

        System.out.println(builder);
    }
}

class Stack {

    int[] arr;
    int index;

    public Stack() {
        arr = new int[100];
        index = 0;
    }

    public void push(int x) {
        if (index == arr.length-1) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }

        arr[index++] = x;
    }

    public int pop() {
        if (index == 0) {
            return -1;
        }

        return arr[index-- - 1];
    }

    public int size() {
        return index;
    }

    public int empty() {
        return index == 0 ? 1 : 0;
    }

    public int top() {
        if (index == 0) {
            return -1;
        }

        return arr[index - 1];
    }
}