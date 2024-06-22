import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int r;
    static int c;
    static int k;

    static int maxX;
    static int maxY;

    static Map<Integer, Integer> map;

    static PriorityQueue<Num> queue = new PriorityQueue<>(new Comparator<Num>() {
        @Override
        public int compare(Num o1, Num o2) {
            if (o1.count == o2.count) {
                return o1.num - o2.num;
            }

            return o1.count - o2.count;
        }
    });

    public static void main(String[] args) throws Exception {

        // R 연산
        // A의 모든 행에 대해 정렬을 수행.
        // C 연산
        // A의 모든 열에 대해 정렬을 수행.

        // 연산을 수행할 떄
        // 행 >= 열 인 경우 R 연산
        // 행 < 열 인 경우 C 연산

        // ex
        // [3, 1, 1] -> [3, 1, 1, 2] -> [2, 1, 3, 1, 1, 2]
        // 등장 횟수가 적은 수 부터 먼저 나온다
        // 등장 횟수가 같다면 값이 더 작은 수가 먼저 나옴.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[101][101];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // arr[r][c] 의 값이 k가 되도록 R, C 연산을 반복할 때 가장 최소 시간을 구하자.

        for (int i = 1; i < 4; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());
    }

    private static int solution() {
        int count = 0;
        maxX = 3;
        maxY = 3;

        while (arr[r][c] != k) {
            if (count >= 100) {
                return -1;
            }

            if (maxX >= maxY) {
                sort(maxX, maxY, false);
            } else {
                sort(maxY, maxX, true);
            }

            count++;
        }

        return count;
    }

    // true -> R, false -> C
    private static void sort(int one, int two, boolean isC) {

        for (int i = 1; i <= one; i++) {
            map = new HashMap<>();

            for (int j = 1; j <= two; j++) {
                if ((isC && arr[j][i] == 0) || (!isC && arr[i][j] == 0)) {
                    continue;
                }

                if (isC) {
                    if (Objects.nonNull(map.get(arr[j][i]))) {
                        map.put(arr[j][i], map.get(arr[j][i]) + 1);
                    } else {
                        map.put(arr[j][i], 1);
                    }
                } else {
                    if (Objects.nonNull(map.get(arr[i][j]))) {
                        map.put(arr[i][j], map.get(arr[i][j]) + 1);
                    } else {
                        map.put(arr[i][j], 1);
                    }
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                queue.offer(new Num(entry.getKey(), entry.getValue()));
            }

            if (isC) {
                maxX = Math.max(maxX, queue.size() * 2);
            } else {
                maxY = Math.max(maxY, queue.size() * 2);
            }

            for (int j = 1; j < 101; j++) {
                if (isC) {
                    arr[j][i] = 0;
                } else {
                    arr[i][j] = 0;
                }
            }

            int index = 1;
            while (!queue.isEmpty()) {
                if (index > 100) {
                    queue.clear();
                    break;
                }
                Num now = queue.poll();

                if (isC) {
                    arr[index++][i] = now.num;
                    arr[index++][i] = now.count;
                } else {
                    arr[i][index++] = now.num;
                    arr[i][index++] = now.count;
                }
            }
        }
    }
}

class Num {

    int num;
    int count;

    public Num(int num, int count) {
        this.num = num;
        this.count = count;
    }
}