package UI;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import model.Block;
import model.Board;

import java.util.ArrayList;
import java.util.Collection;

public class Main extends Application implements EventHandler<ActionEvent> {

    Scene scene;
    Button startButton;
    final int BOX_DIMENSION = 40;
    final int BOARD_DIMENSION = 25;
    Board board;

    @Override
    public void start(Stage primaryStage) throws Exception {
        startButton = new Button("Start");
        GridPane root = new GridPane();
        initializeBoard();
        initializeRoot(root);
        initializeRectEvent();
        primaryStage.setTitle("VisualPath");



        scene = new Scene(root, 1000, 1000);
        scene.setFill(Color.BEIGE);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void initializeRectEvent() {
        for (int i = 0; i < BOARD_DIMENSION; i++) {
            for (int j = 0; j < BOARD_DIMENSION; j++) {
                final int finalJ = j;
                final int finalI = i;
                board.getBlock(i,j).getRect().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (board.getBlock(finalI, finalJ).getRect().getFill() == Color.CORNFLOWERBLUE) {
                            board.getBlock(finalI,finalJ).getRect().setFill(Color.ORANGERED);
                        } else {
                            board.getBlock(finalI,finalJ).getRect().setFill(Color.CORNFLOWERBLUE);
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
                        board.getBlock(i,j).getxPos(),board.getBlock(i,j).getyPos());
            }
        }
    }


    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {

    }

    private Rectangle makeRect(int x, int y) {
        Rectangle rect = new Rectangle();
        rect.setHeight(BOX_DIMENSION);
        rect.setWidth(BOX_DIMENSION);
        rect.setX(x);
        rect.setY(y);
        return rect;
    }

    private void initializeBoard() {
        board = new Board(BOARD_DIMENSION, BOX_DIMENSION);
    }
}
