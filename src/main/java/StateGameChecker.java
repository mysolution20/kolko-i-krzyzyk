import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StateGameChecker {
    private List<Integer> playerPosition = new ArrayList<>();
    private List<Integer> computerPosition = new ArrayList<>();
    private List<String> resultOfWhoWon = new ArrayList<>();
    private List<Integer> draw = new ArrayList<>();

    public StateGameChecker() {
        prepareDraw();
    }

    public void prepareDraw () {
         for (int i = 1; i < 10; i++) {
             draw.add(i);
         }
     }

    private int computerTempPosition = 0;
    private String won = " ";
    Random rand = new Random();
    private boolean continueGame = true;

    public boolean getContinueGame() {
        return continueGame;
    }

    public void repeatGame(){
        playerPosition.clear();
        computerPosition.clear();
        resultOfWhoWon.clear();
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

    public String checkWinner() {
        if (resultOfWhoWon.size() == 0) {
            for (List i : GameConstant.possibleWins) {
                if (playerPosition.containsAll(i)) {
                    resultOfWhoWon.add("I won!");
                    won = resultOfWhoWon.get(0);
                }
            }
        }
        if (resultOfWhoWon.size() == 0) {
            for (List i : GameConstant.possibleWins) {
                if (computerPosition.containsAll(i)) {
                    resultOfWhoWon.add("Computer wins!");
                    won = resultOfWhoWon.get(0);
                }
            }
        }
        if (resultOfWhoWon.size() == 0) {
            if ((playerPosition.size() + computerPosition.size()) >= 9) {
                resultOfWhoWon.add("Nobody has won.");
                won = resultOfWhoWon.get(0);
            }
        }
        return won;
    }

//     if (result.equals("I won!") || result.equals("Computer wins!")){
//
//
//    }

    public List<Integer> getComputerPosition() {
        return computerPosition;
    }
}
