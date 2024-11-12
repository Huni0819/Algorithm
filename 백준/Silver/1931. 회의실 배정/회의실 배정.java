import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Meeting> queue = new PriorityQueue<>(new Comparator<Meeting>() {

            public int compare(Meeting o1, Meeting o2) {
                            
                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }

                return o1.end - o2.end;
            }
        });

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            queue.offer(new Meeting(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        int count = 0;
        int prev = 0;

        for (int i = 0; i < N; i++) {
            Meeting now = queue.poll();

            if (prev <= now.start) {
                count++;
                prev = now.end;
            }
        }

        System.out.print(count);

        
    }
}

class Meeting {

    int start;
    int end;

    public Meeting(int start, int end) {

        this.start = start;
        this.end = end;
    }
}