import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        int sum = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < count; i++) {
            int num = scanner.nextInt();

            queue.add(num);
        }

        while(queue.size() > 1) {
            int n1 = queue.poll();
            int n2 = queue.poll();

            sum += (n1 + n2);

            queue.add(n1+n2);
        }

        System.out.println(sum);
        scanner.close();
     }

}