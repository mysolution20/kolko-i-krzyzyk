import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.*;

public class KolkoIKrzyzyk<e> extends Application {
    Stage window;
    StateGameChecker stateGameChecker = new StateGameChecker();
    Map<Integer, Button> buttonMapPosition = new HashMap<>();
    Image cross = new Image("cross.gif");
    Image circle = new Image("circle.gif");
    Button button1 = new Button();
    Button button2 = new Button();
    Button button3 = new Button();
    Button button4 = new Button();
    Button button5 = new Button();
    Button button6 = new Button();
    Button button7 = new Button();
    Button button8 = new Button();
    Button button9 = new Button();
    Label infoLabel = new Label(GameConstant.gameName);

    Button returnButton = new Button(" Replay");
    Button exitButton = new Button("Exit");

    private void setButtonGraphic(int buttonNumber, Image image) {
        Button tempButtonService = buttonMapPosition.get(buttonNumber);
        tempButtonService.setGraphic(new ImageView(image));
        tempButtonService.setDisable(true);
    }

    private void setButtonDisable(Button button) {
        button.setDisable(true);
    }

    private void setButtonEmptyGraphic(Button button) {
        button.setGraphic(null);
    }

    public void buttonPlayerSetService(int buttonNumber) {
        setButtonGraphic(buttonNumber, cross);
    }

    public void buttonComputerSetService(int buttonNumber) {
        setButtonGraphic(buttonNumber, circle);
    }

    private void closeProgram(Stage window) {
        window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }


    public void markCurrentGameResult(int nrEventButton) {
        stateGameChecker.rememberPlayerChoice(nrEventButton);
        buttonPlayerSetService(nrEventButton);
        for (Integer computerButtonPosition : stateGameChecker.getComputerPosition()) {
            buttonComputerSetService(computerButtonPosition);
        }
        String result = stateGameChecker.checkWinner();
        infoLabel.setText((result.equals(" ")) ? GameConstant.gameName : result);

        if (result.equals("I won!") || result.equals("Computer wins!")) {
            for (Map.Entry<Integer, Button> entry : buttonMapPosition.entrySet()) {
                setButtonDisable(entry.getValue());
            }
        }
    }

    public void prepareButton() {
        stateGameChecker.repeatGame();
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);

        setButtonEmptyGraphic(button1);
        setButtonEmptyGraphic(button2);
        setButtonEmptyGraphic(button3);
        setButtonEmptyGraphic(button4);
        setButtonEmptyGraphic(button5);
        setButtonEmptyGraphic(button6);
        setButtonEmptyGraphic(button7);
        setButtonEmptyGraphic(button8);
        setButtonEmptyGraphic(button9);
        infoLabel.setText(GameConstant.gameName);
    }

    @Override
    public void start(Stage primaryStage) {
        int size = 150;
        int down = 30;
        buttonMapPosition.put(1, button1);
        buttonMapPosition.put(2, button2);
        buttonMapPosition.put(3, button3);
        buttonMapPosition.put(4, button4);
        buttonMapPosition.put(5, button5);
        buttonMapPosition.put(6, button6);
        buttonMapPosition.put(7, button7);
        buttonMapPosition.put(8, button8);
        buttonMapPosition.put(9, button9);

        button1.setOnAction(e -> markCurrentGameResult(1));
        button2.setOnAction(e -> markCurrentGameResult(2));
        button3.setOnAction(e -> markCurrentGameResult(3));
        button4.setOnAction(e -> markCurrentGameResult(4));
        button5.setOnAction(e -> markCurrentGameResult(5));
        button6.setOnAction(e -> markCurrentGameResult(6));
        button7.setOnAction(e -> markCurrentGameResult(7));
        button8.setOnAction(e -> markCurrentGameResult(8));
        button9.setOnAction(e -> markCurrentGameResult(9));

        button1.setLayoutY(down);
        button1.setMaxSize(size, size);
        button1.setMinSize(size, size);

        button2.setLayoutX(size);
        button2.setLayoutY(down);
        button2.setMaxSize(size, size);
        button2.setMinSize(size, size);

        button3.setLayoutX(size + size);
        button3.setLayoutY(down);
        button3.setMaxSize(size, size);
        button3.setMinSize(size, size);

        button4.setLayoutY(size + down);
        button4.setMaxSize(size, size);
        button4.setMinSize(size, size);

        button5.setLayoutX(size);
        button5.setLayoutY(size + down);
        button5.setMaxSize(size, size);
        button5.setMinSize(size, size);

        button6.setLayoutX(size + size);
        button6.setLayoutY(size + down);
        button6.setMaxSize(size, size);
        button6.setMinSize(size, size);

        button7.setLayoutY(size + size + down);
        button7.setMaxSize(size, size);
        button7.setMinSize(size, size);

        button8.setLayoutX(size);
        button8.setLayoutY(size + size + down);
        button8.setMaxSize(size, size);
        button8.setMinSize(size, size);

        button9.setLayoutX(size + size);
        button9.setLayoutY(size + size + down);
        button9.setMaxSize(size, size);
        button9.setMinSize(size, size);

        infoLabel.setLayoutX(151);
        infoLabel.setLayoutY(1);
        infoLabel.setMaxSize(148, 28);
        infoLabel.setMinSize(148, 28);
        infoLabel.setAlignment(Pos.CENTER);

        returnButton.setLayoutX(301);
        returnButton.setLayoutY(1);
        returnButton.setMaxSize(148, 28);
        returnButton.setMinSize(148, 28);
        returnButton.setOnAction(e -> prepareButton());

        exitButton.setLayoutX(1);
        exitButton.setLayoutY(1);
        exitButton.setMaxSize(148, 28);
        exitButton.setMinSize(148, 28);
        exitButton.setOnAction(e -> closeProgram(window));

        // root
        Group group = new Group();
        group.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7, button8, button9, infoLabel, returnButton, exitButton);

        // scene
        Scene scene = new Scene(group);

        // state
        int width = 466;
        int height = width + 26 + down;

        window = primaryStage;
        window.setMaxWidth(width);
        window.setMinWidth(width);
        window.setMinHeight(height);
        window.setMaxHeight(height);
        window.setTitle("Kolko i krzyzyk");
        window.setScene(scene);
        window.setFullScreen(false);
        window.show();
    }
}


