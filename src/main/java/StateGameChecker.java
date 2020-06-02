import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StateGameChecker {
    private final List<Integer> playerPosition = new ArrayList<>();
    private final List<Integer> computerPosition = new ArrayList<>();
    private final List<Integer> draw = new ArrayList<>();
    private boolean wonOne;
    private int computerTempPosition = 0;
    private String won = " ";
    private Winner winner = Winner.NO_ONE;
    Random rand = new Random();

    public StateGameChecker() {
        prepareDraw();
    }

    public void prepareDraw() {
        boolean hasWon = false;
        draw.clear();
        for (int i = 1; i < 10; i++) {
            draw.add(i);
        }
    }

    public void repeatGame() {
        wonOne = false;
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
            draw.remove((Integer) computerTempPosition); //            System.out.println(playerPosition);            System.out.println(computerTempPosition);            System.out.println(draw);
            computerTempPosition = 0;
        }
    }

    public boolean hasWon() {
        wonOne = false;
        for (List i : GameConstant.possibleWins) {
            if (playerPosition.containsAll(i) || computerPosition.containsAll(i)) {
                wonOne = true;
            }
        }
        return wonOne;
    }

//    Winner hasWon = Winner.NO_ONE;
//    public Winner whoIsWinner() {
//        for (List i : GameConstant.possibleWins) {
//            if (playerPosition.containsAll(i)) {
//                hasWon = Winner.PLAYER;
//            } else if (computerPosition.containsAll(i)) {
//                hasWon = Winner.COMPUTER;
//            } else {
//                hasWon = Winner.NO_ONE;
//            }
//        }
//        return hasWon;
//    }

    public String checkWinner() {

//        switch (whoIsWinner()) {
//            case PLAYER:
//                won = "I won!";
//                break;
//            case COMPUTER:
//                won = "Computer wins!";
//                break;
//            case NO_ONE:
//                won = "Nobody has won.";
//                break;
//            default:
//                won = " ";
//                break;
//        }
//        return won;

        if (hasWon()) {
            for (List i : GameConstant.possibleWins) {
                if (playerPosition.containsAll(i)) {
                    won = "I won!";
                }
                if (computerPosition.containsAll(i)) {
                    won = "Computer wins!";
                }
            }
        } else if ((playerPosition.size() + computerPosition.size()) >= 9) {
            won = "Nobody has won.";
        } else {
            won = " ";
        }
        return won;
    }

    public List<Integer> getComputerPosition() {
        return computerPosition;
    }
}
