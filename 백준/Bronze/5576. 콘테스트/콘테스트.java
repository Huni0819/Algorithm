import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> qW = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> qK = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < 10; i++) {

            qW.offer(new Integer(br.readLine()));
        }

        for (int i = 0; i < 10; i++) {

            qK.offer(new Integer(br.readLine()));
        }

        int sumW = 0;
        int sumK = 0;
        for (int i = 0; i < 3; i++) {

            sumW += qW.poll();
            sumK += qK.poll();
        }

        System.out.println(sumW + " " + sumK);
    }


}