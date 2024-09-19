import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner = new Scanner(System.in);

    public int[] getNumbers(int count) {
        // 기능: 사용자로부터 count개 숫자를 입력받음
        try {
            int[] numbers = new int[count];
            int idx = 0;

            System.out.println("숫자를 " + count + "개 입력하세요: ");
            String[] input = scanner.nextLine().trim().split("");

            /*
             * [입력값 유효성 검증]
             * 1. 개수 체크 : count개의 숫자를 입력받았는지 확인
             * 2. 타입 체크 : 숫자를 입력받았는지 확인
             * 3. 범위 체크 : 1 ~ 9 숫자를 입력받았는지 확인
             * 4. 중복 체크 : 입력 받은 숫자에 중복된 숫자가 있는지 확인
             */
            if (input.length != count) {
                throw new IllegalArgumentException();
            }

            for (String s : input) {
                int num = Integer.parseInt(s);

                if (num == 0) {
                    throw new IllegalArgumentException();
                }

                if (Arrays.stream(numbers).anyMatch(n -> n == num)) {
                    throw new IllegalArgumentException();
                }

                numbers[idx] = num;
                idx++;
            }

            return numbers;
        } catch (IllegalArgumentException e ) { // IllegalArgumentException 안에 NumberFormatException 포함되어 있다.
            System.out.println("올바르지 않은 입력값입니다.\n");
            return getNumbers(count);
        }
    }

    public int setCount() {
        try {
            int count = Integer.parseInt(scanner.nextLine().trim());

            if (count != 3 && count != 4 && count != 5) {
                throw new IllegalArgumentException("올바르지 않은 입력값입니다. (only 3, 4, 5 가능)\n");
            }

            return count;

        } catch (NumberFormatException e) {
            throw new NumberFormatException("올바르지 않은 입력값입니다.\n");
        }
    }
}
