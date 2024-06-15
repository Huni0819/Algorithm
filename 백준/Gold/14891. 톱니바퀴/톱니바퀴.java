import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] gears = new List[4];

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            gears[i] = new ArrayList<>();

            String line = reader.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i].add(line.charAt(j) - '0');
            }
        }

        //1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
        //2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
        //3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
        //4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점

        int k = Integer.parseInt(reader.readLine());

        for (int i = 0; i < k; i++) {
            Move[] moves = new Move[4];

            for (int j = 0; j < 4; j++) {
                moves[j] = new Move();
                moves[j].check = false;
            }
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int gearNumber = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            moves[gearNumber].check = true;
            moves[gearNumber].direct = direction;

            int number = gearNumber;
            // 돌릴 톱니바퀴 왼쪽 방향 확인
            while (true) {
                if (number == 0) {
                    break;
                }

                if (!check(number - 1, number)) {
                    moves[number-1].check = true;
                    moves[number-1].direct = moves[number].direct * -1;
                    number--;
                } else {
                    break;
                }
            }

            number = gearNumber;
            // 돌릴 톱니바퀴 오른쪽 방향 확인
            while (true) {
                if (number == 3) {
                    break;
                }

                if (!check(number, number + 1)) {
                    moves[number+1].check = true;
                    moves[number+1].direct = moves[number].direct * -1;
                    number++;
                } else {
                    break;
                }
            }

            for (int j = 0; j < 4; j++) {
                if (moves[j].check) {
                    move(j, moves[j].direct);
                }
            }
        }

        int score = 0;

        score += gears[0].get(0) == 0 ? 0 : 1;
        score += gears[1].get(0) == 0 ? 0 : 2;
        score += gears[2].get(0) == 0 ? 0 : 4;
        score += gears[3].get(0) == 0 ? 0 : 8;

        System.out.println(score);
    }

    private static boolean check(int num1, int num2) {
        return (gears[num1].get(2) == gears[num2].get(6));
    }

    private static void move(int gear, int direct) {
        if (direct == 1) {
            gears[gear].add(0, gears[gear].remove(7));
        } else {
            gears[gear].add(gears[gear].remove(0));
        }
    }
}

class Move {

    boolean check;
    int direct;
}