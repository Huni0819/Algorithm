import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int dx[] = {-1, 1, 1, -1};

    static Shark[][] arr;
    static int R;
    static int C;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new Shark[R + 1][C + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            arr[r][c] = new Shark(s, d, z);
        }

        int sum = 0;
        for (int i = 1; i <= C; i++) {

            for (int j = 1; j <= R; j++) {
                // 제일 먼저 만난 상어의 크기를 더하고 null로 초기화
                if (!Objects.isNull(arr[j][i])) {
                    sum += arr[j][i].z;
                    arr[j][i] = null;
                    break;
                }
            }

            // 상어 이동.
            moveShark();
        }

        System.out.println(sum);
    }

    private static void moveShark() {
        // 각 상어의 위치를 변경해야 함.
        // 상어는 모두 한번에 이동 하므로 이동이 완료 된 상태에서 한번에 정리해야 한다.
        Shark[][] next = new Shark[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                // [i][j]에 상어가 존재하면 다음 위치 계산
                if (!Objects.isNull(arr[i][j])) {
                    int r = i;
                    int c = j;

                    for (int k = 0; k < arr[i][j].s; k++) {
                        if ((r == 1 && arr[i][j].d == 1) || (r == R && arr[i][j].d == 2) || (c == 1 && arr[i][j].d == 4) || (c == C && arr[i][j].d == 3)) {
                            arr[i][j].d += arr[i][j].d % 2 == 0 ? -1 : 1;
                        }

                        if (arr[i][j].d <= 2) { // 상하로 움직이면
                            r += dx[arr[i][j].d - 1];
                        } else { // 좌우로 움직이면
                            c += dx[arr[i][j].d - 1];
                        }
                    }

                    // 이동할 위치가 비어있으면 상어 이동
                    if (Objects.isNull(next[r][c])) {
                        next[r][c] = arr[i][j];
                    } else if (next[r][c].z < arr[i][j].z) { // 이동할 위치에 상어가 존재하면 크기 비교 후 기존 상어보다 크기가 더 크다면 교환
                        next[r][c] = arr[i][j];
                    }
                }
            }
        }

        arr = next;
    }
}

class Shark {

    int s;
    int d;
    int z;

    public Shark(int s, int d, int z) {

        this.s = s;
        this.d = d;
        this.z = z;
    }
}