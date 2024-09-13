import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            BaseballGame baseballGame = new BaseballGame();
            String menuNum;

            while (true) {
                System.out.println("환영합니다! 원하시는 번호를 입력해주세요.\n1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");

                // 번호 입력
                menuNum = scanner.nextLine().trim();
                System.out.println();

                // 게임 시작하기
                if (menuNum.equals("1")) {
                    System.out.println("< 게임을 시작합니다 >");

                    // 랜덤 숫자 3개 생성 (중복 없음)
                    baseballGame.createRandomNumbers();

                    while (true) {
                        // 입력받은 숫자 3개 (중복 없음)
                        int[] inputNumbers = baseballGame.getInputNumbers();

                        // 비교
                        if (baseballGame.play(inputNumbers)) {
                            System.out.println("정답입니다!!");
                            break;
                        }
                    }
                // 게임 기록 보기
                } else if (menuNum.equals("2")) {
                    System.out.println("< 게임 기록 보기 >");
                    baseballGame.printPlayHistory();
                // 게임 종료
                } else if (menuNum.equals("3")) {
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    break;
                } else {
                    System.out.println("올바른 숫자를 입력해주세요!");
                }

                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("[ERROR::" + e.getClass().getName() + "] message: " + e.getMessage());
        }
    }
}
