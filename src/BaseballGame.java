import java.util.Arrays;

public class BaseballGame {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final InputValidator inputValidator = new InputValidator();
    final BaseballGameHistory baseballGameHistory = new BaseballGameHistory();

    private int numberCount = 3;  // 난수 개수 및 사용자 숫자 입력 개수 (default=3)

    public void startGame() {
        int[] randomNumbers = randomNumberGenerator.generateRandomNumbers(numberCount);  // 난수 생성
        int attempt = 0;

        while (true) {
            attempt++;

            // all strike
            if (play(randomNumbers)) {
                System.out.println("정답입니다!! (시도횟수: " + attempt + ")");
                baseballGameHistory.addPlayHistory(attempt);
                break;
            }
        }
    }

    public boolean play(int[] randomNumbers) {
        int[] inputNumbers = inputValidator.getNumbers(numberCount);
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < numberCount; i++) {
            int inputNumber = inputNumbers[i];

            if (randomNumbers[i] == inputNumber) {
                strike++;
            } else if (Arrays.stream(randomNumbers).anyMatch(n -> n == inputNumber)) {
                ball++;
            }
        }

        // 결과 print
        showResult(strike, ball);

        return strike == numberCount;
    }

    public void showResult(int strike, int ball) {
        String answer = "";

        if (strike > 0) {
            answer += strike + "스트라이크 ";
        }

        if (ball > 0) {
            answer += ball + "볼 ";
        }

        if (strike == 0 && ball == 0) {
            answer = "아웃";
        }

        System.out.println(answer + "\n");
    }

    public void changeNumberCount() {
        // 기능: 자리수 설정
        try {
            System.out.println("설정하고자 하는 자리수를 입력하세요.");
            numberCount = inputValidator.setCount();
            System.out.println(numberCount + "자리수 난이도로 설정되었습니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            changeNumberCount();
        }
    }
}
