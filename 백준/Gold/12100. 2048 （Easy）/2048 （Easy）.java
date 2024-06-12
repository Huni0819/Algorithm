import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(arr, 0);
        System.out.println(max);
    }

    private static void solution(int[][] arr, int count) {

        if (count == 5) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max = Math.max(arr[i][j], max);
                }
            }

            return;
        }

        // 한 방향으로 쭉 밀어야 함.
        // 0 : 상, 1 : 하, 2 : 좌, 3 : 우
        for (int k = 0; k < 4; k++) {
            int[][] copy = copy(arr);

            move(copy, k);


            solution(copy, count + 1);
        }
    }

    private static boolean checkSame(int[][] stan, int[][] target) {
        boolean result = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (stan[i][j] != target[i][j]) {
                    result = false;
                }
            }
        }

        return result;
    }

    private static int[][] copy(int[][] arr) {
        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = arr[i][j];
            }
        }

        return copy;
    }

    // direct
    // 0,1 -> x
    // 2,3 -> y
    private static int[][] move(int[][] arr, int direct) {

        int index;
        for (int i = 0; i < n; i++) {
            int[] board = new int[n];

            switch (direct) {

//                  상 - x 위로 이동
                case 0:
                    index = 0;
                    for (int j = 0; j < n; j++) {
                        if (arr[j][i] != 0) {
                            // 아직 값이 들어있지 않은 경우
                            if (board[index] == 0) {
                                board[index] = arr[j][i];

                                // 값이 들어가 있는 경우
                            } else {
                                if (arr[j][i] == board[index]) {
                                    board[index] *= 2;
                                } else {
                                    board[index + 1] = arr[j][i];
                                }
                                index++;
                            }
                        }
                    }

                    for (int j = 0; j < n; j++) {
                        arr[j][i] = board[j];
                    }

                    break;

//                  하 - x 아래로 이동
                case 1:
                    index = n - 1;
                    for (int j = n - 1; j >= 0; j--) {
                        if (arr[j][i] != 0) {
                            // 아직 값이 들어있지 않은 경우
                            if (board[index] == 0) {
                                board[index] = arr[j][i];

                                // 값이 들어가 있는 경우
                            } else {
                                if (arr[j][i] == board[index]) {
                                    board[index] *= 2;
                                } else {
                                    board[index - 1] = arr[j][i];
                                }
                                index--;
                            }
                        }
                    }

                    for (int j = 0; j < n; j++) {
                        arr[j][i] = board[j];
                    }

                    break;
//                  좌
                case 2:
                    index = 0;
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] != 0) {
                            // 아직 값이 들어있지 않은 경우
                            if (board[index] == 0) {
                                board[index] = arr[i][j];

                                // 값이 들어가 있는 경우
                            } else {
                                if (arr[i][j] == board[index]) {
                                    board[index] *= 2;
                                } else {
                                    board[index + 1] = arr[i][j];
                                }
                                index++;
                            }
                        }
                    }

                    for (int j = 0; j < n; j++) {
                        arr[i][j] = board[j];
                    }

                    break;
//                  우
                case 3:
                    index = n - 1;
                    for (int j = n - 1; j >= 0; j--) {
                        if (arr[i][j] != 0) {
                            // 아직 값이 들어있지 않은 경우
                            if (board[index] == 0) {
                                board[index] = arr[i][j];

                                // 값이 들어가 있는 경우
                            } else {
                                if (arr[i][j] == board[index]) {
                                    board[index] *= 2;
                                } else {
                                    board[index - 1] = arr[i][j];
                                }
                                index--;
                            }
                        }
                    }

                    for (int j = 0; j < n; j++) {
                        arr[i][j] = board[j];
                    }
            }

        }

        return arr;
    }

}