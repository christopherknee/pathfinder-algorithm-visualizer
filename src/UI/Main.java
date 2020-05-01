package UI;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;

public class Main extends Application implements EventHandler<ActionEvent> {

    Scene scene;
    Button startButton;

    @Override
    public void start(Stage primaryStage) throws Exception{
        startButton = new Button("Start");
        Box testBox = new Box();
        testBox.setHeight(50);
        testBox.setWidth(testBox.getHeight());
        testBox.setDepth(testBox.getHeight());
        testBox.setMaterial(new PhongMaterial(Color.AQUA));

        Group group = new Group(testBox);


        primaryStage.setTitle("VisualPath");



        scene = new Scene(group, 300, 275);
        scene.setFill(Color.BEIGE);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
