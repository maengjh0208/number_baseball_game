import java.util.Scanner;

public class MenuHandler {
    private final Scanner scanner = new Scanner(System.in);
    private final BaseballGame baseballGame = new BaseballGame();

    public void showMenu() {
        while (true) {
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요.\n0.자리수 설정 1.게임 시작하기 2.게임 기록 보기 3.종료하기");
            selectMenu(scanner.nextLine().trim());  // 메뉴 선택
        }
    }

    private void selectMenu(String menu) {
        System.out.println();

        switch (menu) {
            case "0":
                System.out.println("< 자리수 설정하기 >");
                baseballGame.changeNumberCount();
                System.out.println();
            case "1":
                System.out.println("< 게임 시작하기 >");
                baseballGame.startGame();
                break;
            case "2":
                System.out.println("< 게임 기록 조회 >");
                baseballGame.baseballGameHistory.showPlayHistory();
                break;
            case "3":
                System.out.println("< 게임 종료하기 >");
                System.exit(0);
            default:
                System.out.println("올바른 숫자를 입력해주세요.");
        }

        System.out.println();
    }
}
