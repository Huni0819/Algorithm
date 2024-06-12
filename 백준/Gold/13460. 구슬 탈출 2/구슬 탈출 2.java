import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int m;

    static char[][] arr;
    static Queue<Coord> queue = new LinkedList<>();

    static boolean[][][][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m][n][m];

        Coord init = new Coord(1);
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);

                if (arr[i][j] == 'R') {
                    init.setRx(i);
                    init.setRy(j);

                    arr[i][j] = '.';
                } else if (arr[i][j] == 'B') {
                    init.setBx(i);
                    init.setBy(j);

                    arr[i][j] = '.';
                }
            }
        }

        visited[init.getRx()][init.getRy()][init.getBx()][init.getBy()] = true;

        queue.offer(init);

        System.out.println(solution());
    }

    private static int solution() {

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            if (now.getCount() > 10) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nbx = now.getBx();
                int nby = now.getBy();
                int nrx = now.getRx();
                int nry = now.getRy();

                boolean b = false;
                boolean r = false;

                while (checkBound(nbx + dx[i], nby + dy[i]) && arr[nbx + dx[i]][nby + dy[i]] != '#') {
                    nbx += dx[i];
                    nby += dy[i];

                    if (arr[nbx][nby] == 'O') {
                        b = true;
                        break;
                    }

                }

                while (checkBound(nrx + dx[i], nry + dy[i]) && arr[nrx + dx[i]][nry + dy[i]] != '#') {
                    nrx += dx[i];
                    nry += dy[i];

                    if (arr[nrx][nry] == 'O') {
                        r = true;
                        break;
                    }

                }

                if (b) {
                    continue;
                }

                if (r) {
                    return now.getCount();
                }

                if (nrx == nbx && nry == nby) {
                    switch (i) {
                        case 0:
                            // 빨간 구슬이 더 아래쪽에 있는 경우
                            if (now.getRx() > now.getBx()) {
                                nrx -= dx[i];
                            } else {
                                nbx -= dx[i];
                            }
                            break;
                        case 1:
                            // 빨간 구슬이 더 아래쪽에 있는 경우
                            if (now.getRx() > now.getBx()) {
                                nbx -= dx[i];
                            } else {
                                nrx -= dx[i];
                            }
                            break;
                        case 2:
                            // 빨간 구슬이 더 오른쪽에 있는 경우
                            if (now.getRy() > now.getBy()) {
                                nry -= dy[i];
                            } else {
                                nby -= dy[i];
                            }
                            break;
                        case 3:
                            // 빨간 구슬이 더 오른쪽에 있는 경우
                            if (now.getRy() > now.getBy()) {
                                nby -= dy[i];
                            } else {
                                nry -= dy[i];
                            }
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    queue.offer(new Coord(nbx, nby, nrx, nry, now.getCount() + 1));
                }
            }
        }

        return -1;
    }

    private static boolean checkBound(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }
}

class Coord {

    private int bx;
    private int by;
    private int rx;
    private int ry;
    private int count;

    public Coord(int count) {
        this.count = count;
    }

    public Coord(int bx, int by, int rx, int ry, int count) {
        this.bx = bx;
        this.by = by;
        this.rx = rx;
        this.ry = ry;
        this.count = count;
    }

    public int getBx() {
        return bx;
    }

    public int getBy() {
        return by;
    }

    public int getRx() {
        return rx;
    }

    public int getRy() {
        return ry;
    }

    public int getCount() {
        return count;
    }

    public void setBx(int bx) {
        this.bx = bx;
    }

    public void setBy(int by) {
        this.by = by;
    }

    public void setRx(int rx) {
        this.rx = rx;
    }

    public void setRy(int ry) {
        this.ry = ry;
    }
}