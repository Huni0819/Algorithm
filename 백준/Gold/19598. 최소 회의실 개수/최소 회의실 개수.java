import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringTokenizer st;

        Meeting[] arr = new Meeting[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Meeting(start, end);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }

            return o1.start - o2.start;
        });

        // 가장많이 겹쳐서 회의가 진행되는 시간을 찾는다.
        // 시작시간으로 정렬 후 이전에 시작한 회의들이 끝나는 시간을 확인한다.
        int max = Integer.MIN_VALUE;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {

            queue.offer(arr[i].end);

            // 현재 회의보다 가장 빨리 끝날 회의의 종료시간이 더 작으면 큐에서 제거. (회의 종료)
            while (arr[i].start >= queue.peek()) {
                queue.poll();
            }

            // 큐에 남아있는 회의들은 현재 회의와 같이 진행되는 회의
            max = Math.max(max, queue.size());
        }

        System.out.println(max);


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