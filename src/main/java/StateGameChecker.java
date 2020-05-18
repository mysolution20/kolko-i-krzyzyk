import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StateGameChecker {
    protected ArrayList<Integer> playerPosition = new ArrayList<>();
    protected ArrayList<Integer> computerPosition = new ArrayList<>();
    protected ArrayList<String> resultOfWhoWon = new ArrayList<>();
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
    }


    public void rememberPlayerChoice(int theButton) {
        playerPosition.add(theButton);
        if (GameConstant.draw.size() == 1) {
            playerPosition.add(GameConstant.draw.get(0));
        } else {
            GameConstant.draw.remove(GameConstant.draw.indexOf(theButton));
            while (!(GameConstant.draw.contains(computerTempPosition) || GameConstant.draw.contains(theButton))) {
                computerTempPosition = GameConstant.draw.get(rand.nextInt(GameConstant.draw.size()));
            }
            computerPosition.add(computerTempPosition);
            GameConstant.draw.remove(GameConstant.draw.indexOf(computerTempPosition));
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



    public ArrayList<Integer> getComputerPosition() {
        return computerPosition;
    }
}
