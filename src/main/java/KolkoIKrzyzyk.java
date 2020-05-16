import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.*;

public class KolkoIKrzyzyk extends Application {
    Stage window;
    StateGameChecker stateGameChecker = new StateGameChecker();
    Map<Integer, Button> buttonMapPosition = new HashMap<>();
    private String statementInfo = "Tic-tac-toe";
    private int size = 150;
    private int down = 30;
    Image cross = new Image("cross.gif");
    Image circle = new Image("circle.gif");
    Button button1 = new Button(" ");
    Button button2 = new Button(" ");
    Button button3 = new Button(" ");
    Button button4 = new Button(" ");
    Button button5 = new Button(" ");
    Button button6 = new Button(" ");
    Button button7 = new Button(" ");
    Button button8 = new Button(" ");
    Button button9 = new Button(" ");
    Button infoButton = new Button(statementInfo);

    private void getButton(int tempButton, Image cross) {
        Button tempButtonService = buttonMapPosition.get(tempButton);
        tempButtonService.setGraphic(new ImageView(cross));
        tempButtonService.setDisable(true);
    }

        public void buttonPlayerSetService(int tempButton) {
        getButton(tempButton, cross);
    }

    public void buttonComputerSetService(int tempButton) {
        getButton(tempButton, circle);
    }

    private void closeProgram(Stage window) {
        window.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void eventButtonService(int nrEventButton) {
        stateGameChecker.drawToCheck(nrEventButton);
        buttonPlayerSetService(nrEventButton);
        for (Integer computerButtonPosition : stateGameChecker.getComputerPosition()) {
            buttonComputerSetService(computerButtonPosition);
        }
        infoButton.setOnAction(e -> closeProgram(window));
        String result = stateGameChecker.whoWon();
        infoButton.setText((result.equals(" ")) ? statementInfo : result);
    }

    @Override
    public void start(Stage primaryStage) {

        buttonMapPosition.put(1, button1);
        buttonMapPosition.put(2, button2);
        buttonMapPosition.put(3, button3);
        buttonMapPosition.put(4, button4);
        buttonMapPosition.put(5, button5);
        buttonMapPosition.put(6, button6);
        buttonMapPosition.put(7, button7);
        buttonMapPosition.put(8, button8);
        buttonMapPosition.put(9, button9);

        button1.setOnAction(e -> eventButtonService(1));
        button2.setOnAction(e -> eventButtonService(2));
        button3.setOnAction(e -> eventButtonService(3));
        button4.setOnAction(e -> eventButtonService(4));
        button5.setOnAction(e -> eventButtonService(5));
        button6.setOnAction(e -> eventButtonService(6));
        button7.setOnAction(e -> eventButtonService(7));
        button8.setOnAction(e -> eventButtonService(8));
        button9.setOnAction(e -> eventButtonService(9));

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

        infoButton.setLayoutX(1);
        infoButton.setLayoutY(1);
        infoButton.setMaxSize(447, 28);
        infoButton.setMinSize(447, 28);

        // root
        Group group = new Group();
        group.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7, button8, button9, infoButton);

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


