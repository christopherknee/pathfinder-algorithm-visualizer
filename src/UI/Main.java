package UI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Board;

public class Main extends Application implements EventHandler<ActionEvent> {

    private final int BOX_DIMENSION = 50;
    private final int BOARD_DIMENSION = 20;
    private Board board;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane borderPane = new BorderPane();
        GridPane root = new GridPane();
        initializeBoard();
        initializeRoot(root);
        initializeRectEvent();
        primaryStage.setTitle("VisualPath");
        Button bfsButton = new Button("BFS");
        Button dfsButton = new Button("DFS");
        borderPane.setCenter(root);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        vbox.getChildren().add(bfsButton);
        vbox.getChildren().add(dfsButton);
        borderPane.setRight(vbox);

        initializeButtonEvents(bfsButton, dfsButton);


        Scene scene = new Scene(borderPane, 1050, 1000);
        scene.setFill(Color.BEIGE);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void initializeButtonEvents(Button bfsButton, Button dfsButton) {
        bfsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                board.bfsFind(board.getStart());
                board.resetArr();

            }
        });

        dfsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                board.dfsFind(board.getStart());
                board.resetArr();
            }
        });
    }

    private void initializeRectEvent() {
        for (int i = 0; i < BOARD_DIMENSION; i++) {
            for (int j = 0; j < BOARD_DIMENSION; j++) {
                final int finalJ = j;
                final int finalI = i;
                board.getBlock(i,j).getRect().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (board.getBlock(finalI, finalJ).getRect().getFill() == Color.CORNFLOWERBLUE && !board.getStartReady()) {
                            board.getBlock(finalI,finalJ).getRect().setFill(Color.ORANGERED);
                            board.setStartReady(true);
                            board.setStart(board.getBlock(finalI,finalJ));
                        } else if (board.getStartReady() && board.getBlock(finalI, finalJ).getRect().getFill() == Color.ORANGERED) {
                            board.getBlock(finalI,finalJ).getRect().setFill(Color.CORNFLOWERBLUE);
                            board.setStartReady(false);
                            board.setStart(null);
                        }

                        if (!board.getEndReady() && board.getBlock(finalI, finalJ).getRect().getFill() == Color.CORNFLOWERBLUE && board.getStartReady()) {
                            board.getBlock(finalI,finalJ).getRect().setFill(Color.LIGHTGREEN);
                            board.setEndReady(true);
                        } else if (board.getEndReady() && board.getBlock(finalI, finalJ).getRect().getFill() == Color.LIGHTGREEN) {
                            board.getBlock(finalI, finalJ).getRect().setFill(Color.CORNFLOWERBLUE);
                            board.setEndReady(false);
                        }
                    }
                });
            }
        }
    }

    private void initializeRoot(GridPane root) {
        for (int i = 0; i < BOARD_DIMENSION; i++) {
            for (int j = 0; j < BOARD_DIMENSION; j++) {
                root.add(board.getBlock(i,j).getRect(),
                        board.getBlock(i,j).getxPos()*BOARD_DIMENSION,board.getBlock(i,j).getyPos()*BOARD_DIMENSION);
            }
        }
    }


    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {

    }

    private void initializeBoard() {
        board = new Board(BOARD_DIMENSION, BOX_DIMENSION);
    }
}
