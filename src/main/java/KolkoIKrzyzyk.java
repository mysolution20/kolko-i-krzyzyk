import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class KolkoIKrzyzyk extends Application {
    private static ArrayList<Integer> playerPosition = new ArrayList<>();
    private static ArrayList<Integer> computerPosition = new ArrayList<>();
    private static ArrayList<Integer> draw = new ArrayList<>();
    private static int computerTempPosition = 0;

    public static void drawToCheck(int theButton) {
        Random rand = new Random();
        playerPosition.add(theButton);
        if (draw.size() == 1) {
            playerPosition.add(draw.get(0));
        } else {
            draw.remove(draw.indexOf(theButton));
            int tempInt = 0;
            while (!(draw.contains(computerTempPosition) || draw.contains(theButton))) {
                computerTempPosition = draw.get(rand.nextInt(draw.size()));
            }
            computerPosition.add(computerTempPosition);
            draw.remove(draw.indexOf(computerTempPosition));
            computerTempPosition = 0;
        }
    }

    public static String whoWon() {
        List<List> possibleWins = new ArrayList<>();
        possibleWins.add(Arrays.asList(1, 2, 3));
        possibleWins.add(Arrays.asList(4, 5, 6));
        possibleWins.add(Arrays.asList(7, 8, 9));
        possibleWins.add(Arrays.asList(1, 4, 7));
        possibleWins.add(Arrays.asList(2, 5, 8));
        possibleWins.add(Arrays.asList(3, 6, 9));
        possibleWins.add(Arrays.asList(1, 5, 9));
        possibleWins.add(Arrays.asList(3, 5, 7));

        String won = " ";

        for (List i : possibleWins) {
            if (playerPosition.containsAll(i)) {
                won = "I won!";
            } else if (computerPosition.containsAll(i)) {
                won = "Computer wins!";
            } else if (((playerPosition.size() + computerPosition.size()) == 9)) {
                won = "Nobody has won.";
            }
        }
        return won;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        int Size = 150;
        for (int i = 1; i < 10; i++) {
            draw.add(i);
        }
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

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int nrButton = 1;

                drawToCheck(nrButton);
                System.out.println(whoWon());

                button1.setGraphic(new ImageView(cross));
                button1.setDisable(true);

                for (Integer cpuP : computerPosition) {
                    switch (cpuP) {

                        case 1:
                            button1.setGraphic(new ImageView(circle));
                            button1.setDisable(true);
                            break;
                        case 2:
                            button2.setGraphic(new ImageView(circle));
                            button2.setDisable(true);
                            break;
                        case 3:
                            button3.setGraphic(new ImageView(circle));
                            button3.setDisable(true);
                            break;
                        case 4:
                            button4.setGraphic(new ImageView(circle));
                            button4.setDisable(true);
                            break;
                        case 5:
                            button5.setGraphic(new ImageView(circle));
                            button5.setDisable(true);
                            break;
                        case 6:
                            button6.setGraphic(new ImageView(circle));
                            button6.setDisable(true);
                            break;
                        case 7:
                            button7.setGraphic(new ImageView(circle));
                            button7.setDisable(true);
                            break;
                        case 8:
                            button8.setGraphic(new ImageView(circle));
                            button8.setDisable(true);
                            break;
                        case 9:
                            button9.setGraphic(new ImageView(circle));
                            button9.setDisable(true);
                            break;
                    }
                }
            }
        });

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int nrButton = 2;

                drawToCheck(nrButton);
                System.out.println(whoWon());

                button2.setGraphic(new ImageView(cross));
                button2.setDisable(true);

                for (Integer cpuP : computerPosition) {
                    switch (cpuP) {

                        case 1:
                            button1.setGraphic(new ImageView(circle));
                            button1.setDisable(true);
                            break;
                        case 2:
                            button2.setGraphic(new ImageView(circle));
                            button2.setDisable(true);
                            break;
                        case 3:
                            button3.setGraphic(new ImageView(circle));
                            button3.setDisable(true);
                            break;
                        case 4:
                            button4.setGraphic(new ImageView(circle));
                            button4.setDisable(true);
                            break;
                        case 5:
                            button5.setGraphic(new ImageView(circle));
                            button5.setDisable(true);
                            break;
                        case 6:
                            button6.setGraphic(new ImageView(circle));
                            button6.setDisable(true);
                            break;
                        case 7:
                            button7.setGraphic(new ImageView(circle));
                            button7.setDisable(true);
                            break;
                        case 8:
                            button8.setGraphic(new ImageView(circle));
                            button8.setDisable(true);
                            break;
                        case 9:
                            button9.setGraphic(new ImageView(circle));
                            button9.setDisable(true);
                            break;
                    }
                }
            }
        });

        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int nrButton = 3;

                drawToCheck(nrButton);
                System.out.println(whoWon());

                button3.setGraphic(new ImageView(cross));
                button3.setDisable(true);

                for (Integer cpuP : computerPosition) {
                    switch (cpuP) {

                        case 1:
                            button1.setGraphic(new ImageView(circle));
                            button1.setDisable(true);
                            break;
                        case 2:
                            button2.setGraphic(new ImageView(circle));
                            button2.setDisable(true);
                            break;
                        case 3:
                            button3.setGraphic(new ImageView(circle));
                            button3.setDisable(true);
                            break;
                        case 4:
                            button4.setGraphic(new ImageView(circle));
                            button4.setDisable(true);
                            break;
                        case 5:
                            button5.setGraphic(new ImageView(circle));
                            button5.setDisable(true);
                            break;
                        case 6:
                            button6.setGraphic(new ImageView(circle));
                            button6.setDisable(true);
                            break;
                        case 7:
                            button7.setGraphic(new ImageView(circle));
                            button7.setDisable(true);
                            break;
                        case 8:
                            button8.setGraphic(new ImageView(circle));
                            button8.setDisable(true);
                            break;
                        case 9:
                            button9.setGraphic(new ImageView(circle));
                            button9.setDisable(true);
                            break;
                    }
                }
            }
        });


        button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int nrButton = 4;

                drawToCheck(nrButton);

                System.out.println(whoWon());

                button4.setGraphic(new ImageView(cross));
                button4.setDisable(true);

                for (Integer cpuP : computerPosition) {
                    switch (cpuP) {

                        case 1:
                            button1.setGraphic(new ImageView(circle));
                            button1.setDisable(true);
                            break;
                        case 2:
                            button2.setGraphic(new ImageView(circle));
                            button2.setDisable(true);
                            break;
                        case 3:
                            button3.setGraphic(new ImageView(circle));
                            button3.setDisable(true);
                            break;
                        case 4:
                            button4.setGraphic(new ImageView(circle));
                            button4.setDisable(true);
                            break;
                        case 5:
                            button5.setGraphic(new ImageView(circle));
                            button5.setDisable(true);
                            break;
                        case 6:
                            button6.setGraphic(new ImageView(circle));
                            button6.setDisable(true);
                            break;
                        case 7:
                            button7.setGraphic(new ImageView(circle));
                            button7.setDisable(true);
                            break;
                        case 8:
                            button8.setGraphic(new ImageView(circle));
                            button8.setDisable(true);
                            break;
                        case 9:
                            button9.setGraphic(new ImageView(circle));
                            button9.setDisable(true);
                            break;
                    }
                }
            }
        });

        button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int nrButton = 5;

                drawToCheck(nrButton);
                System.out.println(whoWon());

                button5.setGraphic(new ImageView(cross));
                button5.setDisable(true);

                for (Integer cpuP : computerPosition) {
                    switch (cpuP) {

                        case 1:
                            button1.setGraphic(new ImageView(circle));
                            button1.setDisable(true);
                            break;
                        case 2:
                            button2.setGraphic(new ImageView(circle));
                            button2.setDisable(true);
                            break;
                        case 3:
                            button3.setGraphic(new ImageView(circle));
                            button3.setDisable(true);
                            break;
                        case 4:
                            button4.setGraphic(new ImageView(circle));
                            button4.setDisable(true);
                            break;
                        case 5:
                            button5.setGraphic(new ImageView(circle));
                            button5.setDisable(true);
                            break;
                        case 6:
                            button6.setGraphic(new ImageView(circle));
                            button6.setDisable(true);
                            break;
                        case 7:
                            button7.setGraphic(new ImageView(circle));
                            button7.setDisable(true);
                            break;
                        case 8:
                            button8.setGraphic(new ImageView(circle));
                            button8.setDisable(true);
                            break;
                        case 9:
                            button9.setGraphic(new ImageView(circle));
                            button9.setDisable(true);
                            break;
                    }
                }
            }
        });

        button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int nrButton = 6;

                drawToCheck(nrButton);
                System.out.println(whoWon());

                button6.setGraphic(new ImageView(cross));
                button6.setDisable(true);

                for (Integer cpuP : computerPosition) {
                    switch (cpuP) {

                        case 1:
                            button1.setGraphic(new ImageView(circle));
                            button1.setDisable(true);
                            break;
                        case 2:
                            button2.setGraphic(new ImageView(circle));
                            button2.setDisable(true);
                            break;
                        case 3:
                            button3.setGraphic(new ImageView(circle));
                            button3.setDisable(true);
                            break;
                        case 4:
                            button4.setGraphic(new ImageView(circle));
                            button4.setDisable(true);
                            break;
                        case 5:
                            button5.setGraphic(new ImageView(circle));
                            button5.setDisable(true);
                            break;
                        case 6:
                            button6.setGraphic(new ImageView(circle));
                            button6.setDisable(true);
                            break;
                        case 7:
                            button7.setGraphic(new ImageView(circle));
                            button7.setDisable(true);
                            break;
                        case 8:
                            button8.setGraphic(new ImageView(circle));
                            button8.setDisable(true);
                            break;
                        case 9:
                            button9.setGraphic(new ImageView(circle));
                            button9.setDisable(true);
                            break;
                    }
                }
            }
        });

        button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int nrButton = 7;

                drawToCheck(nrButton);
                System.out.println(whoWon());

                button7.setGraphic(new ImageView(cross));
                button7.setDisable(true);

                for (Integer cpuP : computerPosition) {
                    switch (cpuP) {

                        case 1:
                            button1.setGraphic(new ImageView(circle));
                            button1.setDisable(true);
                            break;
                        case 2:
                            button2.setGraphic(new ImageView(circle));
                            button2.setDisable(true);
                            break;
                        case 3:
                            button3.setGraphic(new ImageView(circle));
                            button3.setDisable(true);
                            break;
                        case 4:
                            button4.setGraphic(new ImageView(circle));
                            button4.setDisable(true);
                            break;
                        case 5:
                            button5.setGraphic(new ImageView(circle));
                            button5.setDisable(true);
                            break;
                        case 6:
                            button6.setGraphic(new ImageView(circle));
                            button6.setDisable(true);
                            break;
                        case 7:
                            button7.setGraphic(new ImageView(circle));
                            button7.setDisable(true);
                            break;
                        case 8:
                            button8.setGraphic(new ImageView(circle));
                            button8.setDisable(true);
                            break;
                        case 9:
                            button9.setGraphic(new ImageView(circle));
                            button9.setDisable(true);
                            break;
                    }
                }
            }
        });

        button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int nrButton = 8;

                drawToCheck(nrButton);
                System.out.println(whoWon());

                button8.setGraphic(new ImageView(cross));
                button8.setDisable(true);

                for (Integer cpuP : computerPosition) {
                    switch (cpuP) {

                        case 1:
                            button1.setGraphic(new ImageView(circle));
                            button1.setDisable(true);
                            break;
                        case 2:
                            button2.setGraphic(new ImageView(circle));
                            button2.setDisable(true);
                            break;
                        case 3:
                            button3.setGraphic(new ImageView(circle));
                            button3.setDisable(true);
                            break;
                        case 4:
                            button4.setGraphic(new ImageView(circle));
                            button4.setDisable(true);
                            break;
                        case 5:
                            button5.setGraphic(new ImageView(circle));
                            button5.setDisable(true);
                            break;
                        case 6:
                            button6.setGraphic(new ImageView(circle));
                            button6.setDisable(true);
                            break;
                        case 7:
                            button7.setGraphic(new ImageView(circle));
                            button7.setDisable(true);
                            break;
                        case 8:
                            button8.setGraphic(new ImageView(circle));
                            button8.setDisable(true);
                            break;
                        case 9:
                            button9.setGraphic(new ImageView(circle));
                            button9.setDisable(true);
                            break;
                    }
                }
            }
        });

        button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                int nrButton = 9;

                drawToCheck(nrButton);
                System.out.println(whoWon());

                button9.setGraphic(new ImageView(cross));
                button9.setDisable(true);

                for (Integer cpuP : computerPosition) {
                    switch (cpuP) {

                        case 1:
                            button1.setGraphic(new ImageView(circle));
                            button1.setDisable(true);
                            break;
                        case 2:
                            button2.setGraphic(new ImageView(circle));
                            button2.setDisable(true);
                            break;
                        case 3:
                            button3.setGraphic(new ImageView(circle));
                            button3.setDisable(true);
                            break;
                        case 4:
                            button4.setGraphic(new ImageView(circle));
                            button4.setDisable(true);
                            break;
                        case 5:
                            button5.setGraphic(new ImageView(circle));
                            button5.setDisable(true);
                            break;
                        case 6:
                            button6.setGraphic(new ImageView(circle));
                            button6.setDisable(true);
                            break;
                        case 7:
                            button7.setGraphic(new ImageView(circle));
                            button7.setDisable(true);
                            break;
                        case 8:
                            button8.setGraphic(new ImageView(circle));
                            button8.setDisable(true);
                            break;
                        case 9:
                            button9.setGraphic(new ImageView(circle));
                            button9.setDisable(true);
                            break;
                    }
                }
            }
        });

        button1.setMaxSize(Size, Size);
        button1.setMinSize(Size, Size);

        button2.setLayoutX(Size);
        button2.setMaxSize(Size, Size);
        button2.setMinSize(Size, Size);

        button3.setLayoutX(Size * 2);
        button3.setMaxSize(Size, Size);
        button3.setMinSize(Size, Size);

        button4.setLayoutY(Size);
        button4.setMaxSize(Size, Size);
        button4.setMinSize(Size, Size);

        button5.setLayoutX(Size);
        button5.setLayoutY(Size);
        button5.setMaxSize(Size, Size);
        button5.setMinSize(Size, Size);

        button6.setLayoutX(Size * 2);
        button6.setLayoutY(Size);
        button6.setMaxSize(Size, Size);
        button6.setMinSize(Size, Size);

        button7.setLayoutY(Size * 2);
        button7.setMaxSize(Size, Size);
        button7.setMinSize(Size, Size);

        button8.setLayoutX(Size);
        button8.setLayoutY(Size * 2);
        button8.setMaxSize(Size, Size);
        button8.setMinSize(Size, Size);

        button9.setLayoutX(Size * 2);
        button9.setLayoutY(Size * 2);
        button9.setMaxSize(Size, Size);
        button9.setMinSize(Size, Size);

        // root
        Group group = new Group();

        group.getChildren().add(button1);
        group.getChildren().add(button2);
        group.getChildren().add(button3);
        group.getChildren().add(button4);
        group.getChildren().add(button5);
        group.getChildren().add(button6);
        group.getChildren().add(button7);
        group.getChildren().add(button8);
        group.getChildren().add(button9);
        // scene
        Scene scene = new Scene(group);

        // state
        int width = 463;
        int height = width + 26;

        primaryStage.setMaxWidth(width);
        primaryStage.setMinWidth(width);
        primaryStage.setMinHeight(height);
        primaryStage.setMaxHeight(height);
        primaryStage.setTitle("Kolko i krzyzyk");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(false);
        primaryStage.show();

    }
}


