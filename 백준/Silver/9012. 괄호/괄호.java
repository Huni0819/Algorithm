import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            Stack stack = new Stack();

            boolean check = true;
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '(') {
                    stack.push();
                } else if (line.charAt(j) == ')') {
                    if (!stack.pop()) {
                        check = false;
                        break;
                    }
                }
            }

            print(check, stack);
        }
    }

    private static void print(boolean check, Stack stack) {
        if (check && stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

class Stack {
    private Node head;
    private int count;

    private static class Node {
        Node next;
    }

    public Stack() {
        head = null;
        count = 0;
    }

    public void push() {
        Node newNode = new Node();
        if (head == null) {
            head = newNode;
        } else {
            Node current = head.next;
            Node previous = head;

            while (current != null) {
                previous = current;
                current = current.next;
            }

            previous.next = newNode;
        }

        count++;
    }

    public boolean pop() {
        if (head == null) {
            return false;
        } else {
            if (head.next == null) {
                head = null;
            } else {
                Node current = head.next;
                Node previous = head;

                while (current.next != null) {
                    previous = current;
                    current = current.next;
                }

                previous.next = null;
            }
            count--;
            return true;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }
}