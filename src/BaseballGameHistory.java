import java.util.ArrayList;
import java.util.List;

public class BaseballGameHistory {
    private final List<Integer> playHistory = new ArrayList<>();

    public void addPlayHistory(int attempt) {
        playHistory.add(attempt);
    }

    public void showPlayHistory() {
        // 기능: 숫자 야구 게임 기록 전체 조회
        if (playHistory.isEmpty()) {
            System.out.println("게임 기록이 없습니다.");
        } else {
            for (int i = 0; i < playHistory.size(); i++) {
                System.out.println((i + 1) + "번째 게임 : 시도 횟수 - " + playHistory.get(i));
            }
        }
    }
}
