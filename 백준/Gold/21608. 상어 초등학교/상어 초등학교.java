import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;

    static int[][][] arr;
    static Student[] students;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        arr = new int[n + 1][n + 1][2];
        students = new Student[n * n];

        StringTokenizer st;
        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(reader.readLine());

            students[i] = new Student(Integer.parseInt(st.nextToken()));
            for (int j = 0; j < 4; j++) {
                students[i].favorites[j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();

        int satisfaction = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                Student student = students[arr[i][j][1]];

                int count = 0;

                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 1 || nx >= n+1 || ny < 1 || ny >= n+1) {
                        continue;
                    }

                    for (int l = 0; l < 4; l++) {
                        if (arr[nx][ny][0] == student.favorites[l]) {
                            count++;
                            break;
                        }
                    }
                }

                if (count != 0) {
                    satisfaction += Math.pow(10, count-1);
                }
            }
        }

        System.out.println(satisfaction);
    }

    /*
     * 학생 자리 정하는 조건
     * 1. 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정함.
     * 2. 1을 만족하는 칸이 여러 개일 경우, 인접 칸 중 비어있는 칸이 가장 많은 칸으로 정함.
     * 3. 2를 만복하는 칸도 여러 개면, 행의 번호가 가장 작은칸. 이것도 여러 개면 열의 번호가 가장 작은 칸.
     */
    private static void solution() {

        for (int k = 0; k < students.length; k++) {
            Student student = students[k];

            List<Point> list = new ArrayList<>();

            // 비어있는 자리 list에 넣기
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {

                    if (arr[i][j][0] == 0) {
                        list.add(new Point(i, j));
                    }
                }
            }

            //각 자리 별 인접한 좋아하는 친구 수 및 빈 자리 계산
            for (Point point : list) {

                for (int i = 0; i < 4; i++) {
                    int nx = point.x + dx[i];
                    int ny = point.y + dy[i];

                    if (nx < 1 || nx >= n+1 || ny < 1 || ny >= n+1) {
                        continue;
                    }

                    for (int j = 0; j < 4; j++) {
                        if (arr[nx][ny][0] == student.favorites[j]) {
                            point.countFavorite++;
                        } else if (arr[nx][ny][0] == 0) {
                            point.countEmpty++;
                        }
                    }
                }
            }

            // 각 기준에 맞게 정렬
            Collections.sort(list, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {

                    // 1번 조건을 만족하는게 여러 개면
                    if (o1.countFavorite == o2.countFavorite) {

                        // 2번 조건을 만족하는게 여러 개면
                        if (o1.countEmpty == o2.countEmpty) {

                            // 행의 번호 마저 같다면
                            if (o1.x == o2.x) {
                                // 열의 번호로 정렬
                                return o1.y - o2.y;
                            }

                            // 행의 번호로 정렬
                            return o1.x - o2.x;
                        }

                        // 2번 조건으로 정렬
                        return o2.countEmpty - o1.countEmpty;
                    }

                    // 1번 조건으로 정렬
                    return o2.countFavorite - o1.countFavorite;
                }
            });

            arr[list.get(0).x][list.get(0).y][0] = student.studentNumber;
            arr[list.get(0).x][list.get(0).y][1] = k;
        }
    }

}

class Point {

    int x;
    int y;

    int countFavorite;
    int countEmpty;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.countFavorite = 0;
        this.countEmpty = 0;
    }
}

class Student {

    int studentNumber;
    int[] favorites;

    public Student(int studentNumber) {
        this.studentNumber = studentNumber;
        this.favorites = new int[4];
    }
}