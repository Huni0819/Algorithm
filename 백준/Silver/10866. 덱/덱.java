import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque deque = new Deque();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            String[] info = line.split(" ");

            switch (info[0]) {
                case "push_front":
                    deque.pushFront(Integer.parseInt(info[1]));
                    break;
                case "push_back":
                    deque.pushBack(Integer.parseInt(info[1]));
                    break;
                case "pop_front":
                    System.out.println(deque.popFront());
                    break;
                case "pop_back":
                    System.out.println(deque.popBack());
                    break;
                case "size":
                    System.out.println(deque.size());
                    break;
                case "empty":
                    System.out.println(deque.empty());
                    break;
                case "front":
                    System.out.println(deque.front());
                    break;
                case "back":
                    System.out.println(deque.back());
                    break;
            }
        }
    }
}

class Deque {
    private int count;
    private Node head;
    private Node tail;

    private class Node {
        int item;
        Node next;
        Node previous;

        public Node(int item) {
            this.item = item;
            this.next = null;
            this.previous = null;
        }
    }

    public Deque() {
        count = 0;
        head = null;
        tail = null;
    }

    public int empty() {
        return count == 0 ? 1 : 0;
    }

    public void pushFront(int item) {
        Node newNode = new Node(item);

        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }

        count++;
    }

    public void pushBack(int item) {
        Node newNode = new Node(item);

        if(head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }

        count++;
    }

    public int popFront() {
        if (empty() == 1) {
            return -1;
        }

        int item = head.item;

        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }

        count--;

        return item;
    }

    public int popBack() {
        if (empty() == 1) {
            return -1;
        }

        int item = tail.item;

        if (tail.previous == null) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }

        count--;

        return item;
    }

    public int front() {
        if (empty() == 1) {
            return -1;
        }
        return head.item;
    }

    public int back() {
        if (empty() == 1) {
            return -1;
        }
        return tail.item;
    }

    public int size() {
        return count;
    }
}