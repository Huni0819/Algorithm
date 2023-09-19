import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int statementNumber = Integer.valueOf(br.readLine());

        MyQueue myQueue = new MyQueue();

        for (int i = 0; i < statementNumber; i++) {
            String line = br.readLine();

            switch (line) {
                case "pop":
                    System.out.println(myQueue.pop());
                    break;
                case "size":
                    System.out.println(myQueue.size());
                    break;
                case "empty":
                    System.out.println(myQueue.empty());
                    break;
                case "front":
                    System.out.println(myQueue.front());
                    break;
                case "back":
                    System.out.println(myQueue.back());
                    break;
                default:
                    int index = line.indexOf(" ");
                    int pushNumber = Integer.valueOf(line.substring(index + 1));
                    myQueue.push(pushNumber);
            }
        }

    }
}

class MyQueue {
    private int[] numbers;
    private static int count = 0;

    public MyQueue() {
        numbers = new int[10000];

    }

    public void push(int x) {
        numbers[count++] = x;
    }

    public int pop() {
        if (count == 0) {
            return -1;
        }
        int popNumber = numbers[0];

        for (int i = 1; i < count; i++) {
            numbers[i - 1] = numbers[i];
        }

        count--;

        return popNumber;
    }

    public int size() {
        return this.count;
    }

    public int empty() {
        if (count == 0) {
            return 1;
        }

        return 0;
    }

    public int front() {
        if (count == 0) {
            return -1;
        }

        return numbers[0];
    }

    public int back() {
        if (count == 0) {
            return -1;
        }

        return numbers[count - 1];
    }

}
