import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BaseballGame {
    private int[] randomNumbers;
    private final ArrayList<Integer> playHistory = new ArrayList<>();

    public boolean play(int[] inputNumbers) {
        int strike = 0;
        int ball = 0;
        int out = 0;

        for (int i = 0; i < inputNumbers.length; i++) {
            int playerNumber = inputNumbers[i];

            if (randomNumbers[i] == playerNumber) {
                strike++;
            } else if (Arrays.stream(randomNumbers).anyMatch(n -> n == playerNumber)) {
                ball++;
            } else {
                out++;
            }
        }

        // 게임 기록 업데이트
        playHistory.set(playHistory.size() - 1, playHistory.get(playHistory.size() - 1) + 1);

        // 문구 출력 (ex. 1스트라이크 1볼)
        printCurrentPlayStatus(strike, ball, out);

        return strike == 3;
    }

    public void printPlayHistory() {
        if (!playHistory.isEmpty()) {
            for (int i = 0; i < playHistory.size(); i++) {
                System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + playHistory.get(i));
            }
        } else {
            System.out.println("게임 기록이 없습니다.");
        }
    }

    public static void printCurrentPlayStatus(int strike, int ball, int out) {
        String answer = "";


        if (strike > 0) {
            answer += strike + "스트라이크 ";
        }

        if (ball > 0) {
            answer += ball + "볼 ";
        }

        if (out == 3) {
            answer = "아웃";
        }

        System.out.println(answer);
    }

    public void createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }

        // 1 ~ 9 숫자 섞기
        Collections.shuffle(numbers);

        // 선택된 무작위 숫자 3개 선택 (중복 없음)
        List<Integer> selectedNumbers = numbers.subList(0, 3);
        randomNumbers = selectedNumbers.stream().mapToInt(i -> i).toArray();

        // 초기화
        playHistory.add(0);
    }

    public int[] getInputNumbers() throws IOException {
        /* 사용자로부터 숫자 3개를 입력 받음  */
        try {
            int[] inputNumbers = new int[3];
            int count = 0;
            int totalCount = 3;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("숫자를 입력하세요: ");
            String[] input = br.readLine().split("");

            /*
            * [유효성 검증 순서]
            * 1. 타입 체크 : 숫자를 입력받았는지 확인
            * 2. 개수 체크 : 3개의 숫자를 입력받았는지 확인
            * 3. 범위 체크 : 1 ~ 9 숫자를 입력받았는지 확인
            * 4. 중복 체크 : 입력 받은 숫자에 중복된 숫자가 있는지 확인
            */
            for (String s : input) {
                int num = Integer.parseInt(s);

                if (count == totalCount) {
                    throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
                }

                if (num < 1 || num > 9) {
                    throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
                }

                if (Arrays.stream(inputNumbers).anyMatch(n -> n == num)) {
                    throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
                }

                inputNumbers[count] = num;
                count++;
            }

            return inputNumbers;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("올바르지 않은 입력값입니다.");
        }
    }
}
