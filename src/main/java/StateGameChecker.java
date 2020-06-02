import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StateGameChecker {
    private final List<Integer> playerPosition = new ArrayList<>();
    private final List<Integer> computerPosition = new ArrayList<>();
    private final List<Integer> draw = new ArrayList<>();
    private int computerTempPosition = 0;
    private String won;
    Winner hasWon;
    Random rand = new Random();

    public StateGameChecker() {
        prepareDraw();
    }

    public void prepareDraw() {
        draw.clear();
        for (int i = 1; i < 10; i++) {
            draw.add(i);
        }
    }

    public void repeatGame() {
        won = GameConstant.gameName;
        playerPosition.clear();
        computerPosition.clear();
        prepareDraw();
    }

    public void rememberPlayerChoice(int theButton) {
        playerPosition.add(theButton);
        if (draw.size() == 1) {
            playerPosition.add(draw.get(0));
        } else {
            draw.remove((Integer) theButton);
            while (!(draw.contains(computerTempPosition) || draw.contains(theButton))) {
                computerTempPosition = draw.get(rand.nextInt(draw.size()));
            }
            computerPosition.add(computerTempPosition);
            draw.remove((Integer) computerTempPosition);
            computerTempPosition = 0;
        }
    }

    public Winner whoIsWinner() {
        for (List i : GameConstant.possibleWins) {
            if (playerPosition.containsAll(i)) {
                hasWon = Winner.PLAYER;
                break;
            } else if (computerPosition.containsAll(i)) {
                hasWon = Winner.COMPUTER;
                break;
            } else if (playerPosition.size() + computerPosition.size() >= 9 && hasWon != Winner.PLAYER ||
                    playerPosition.size() + computerPosition.size() >= 9 && hasWon != Winner.COMPUTER) {
                hasWon = Winner.NO_ONE;
            } else {
                hasWon = Winner.EMPTY;
            }
        }
        return hasWon;
    }

    public String checkWinner() {
        switch (whoIsWinner()) {
            case PLAYER:
                won = "I won!";
                break;
            case COMPUTER:
                won = "Computer wins!";
                break;
            case NO_ONE:
                won = "Nobody has won.";
                break;
            case EMPTY:
                won = GameConstant.gameName;
                break;
        }
        return won;
    }

    public List<Integer> getComputerPosition() {
        return computerPosition;
    }
}
