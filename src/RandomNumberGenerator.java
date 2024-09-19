import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    public int[] generateRandomNumbers(int count) {
        /* count개수 만큼 중복 없이 난수를 생성한다. count는 3, 4, 5만 허용 */

        if (count < 1 || count > 10) {
            throw new IllegalArgumentException("올바르지 않은 count 개수::" + count);
        }

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }

        // 1 ~ 9 숫자 섞기
        Collections.shuffle(numbers);

        // 선택된 무작위 숫자 count개 선택
        List<Integer> selectedNumbers = numbers.subList(0, count);
        return selectedNumbers.stream().mapToInt(i -> i).toArray();
    }
}
