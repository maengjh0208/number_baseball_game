import java.util.Scanner;

public class MenuHandler {
    private final Scanner scanner = new Scanner(System.in);
    private final BaseballGame baseballGame = new BaseballGame();

    public void showMenu() {
        String number;

        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요.\n0.자리수 설정 1.게임 시작하기 2.게임 기록 보기 3.종료하기");
            number = scanner.nextLine().trim();  // 번호 입력
            selectMenu(number);                  // 메뉴 선택
        }
    }

    private void selectMenu(String menu) {
        System.out.println();

        switch (menu) {
            case "0" -> baseballGame.changeNumberCount(); // 자리수 설정
            case "1" -> baseballGame.startGame();         // 게임 시작
            case "2" -> baseballGame.baseballGameHistory.showPlayHistory();  // 게임 기록 조회
            case "3" -> {                                 // 게임 종료
                System.out.println("게임을 종료합니다.");
                System.exit(0);
            }
            default -> System.out.println("올바른 숫자를 입력해주세요.");
        }

        System.out.println();
    }
}
