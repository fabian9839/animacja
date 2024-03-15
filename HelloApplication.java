package com.example.animacja;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        TilePane r = new TilePane();
        r.setPrefColumns(3);
        Label l = new Label("Animacja");
        Label n1 = new Label(" ");
        Label n2 = new Label(" ");
        Label n3 = new Label(" ");
        Label n4 = new Label(" ");
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        r.setStyle("-fx-background-color: red");


        Rectangle rect = new Rectangle(120,100, 100, 100);
        rect.setFill(Color.BLUE);

        Button start = new Button("Start");
        Button stop = new Button("Stop");
        Button tworca = new Button("Twórca");



        r.getChildren().add(n1);
        r.getChildren().add(l);
        r.getChildren().add(n2);
        r.getChildren().add(start);
        r.getChildren().add(stop);
        r.getChildren().add(tworca);
        r.getChildren().add(n3);
        r.getChildren().add(rect);
        r.getChildren().add(n4);

        RotateTransition rt = new RotateTransition();
        rt.setDelay(Duration.millis(500));
        rt.setDuration(Duration.seconds(5));

        rt.setNode(rect);
        rt.setByAngle(360);
        rt.setAutoReverse(true);

        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                rt.play();
            }
        };

        EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                rt.stop();
            }
        };

        EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                a.setContentText("Twórca: Fabian Grzywacz");
                a.show();
            }
        };

        start.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        stop.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler1);
        tworca.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);

        Group root = new Group(r);
        Scene scene = new Scene(root, 300, 400);
        stage.setTitle("Animacja");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}