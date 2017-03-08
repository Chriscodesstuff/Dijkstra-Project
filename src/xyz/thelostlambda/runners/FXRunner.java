package xyz.thelostlambda.runners;

//javafx imports
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//dijkstra imports
import xyz.thelostlambda.util.*;

public class FXRunner extends Application {
  public void start (Stage primaryStage) {
    Group root = new Group();
    Scene scene = new Scene(root);

    primaryStage.setTitle("Dope");
    primaryStage.setScene(scene);
    primaryStage.show();
    //not animation stuff
    Grid grid = new Grid();
    grid.addBarrier(5,5,5,5);
    grid.addNode(1,1);
    grid.findNodeNeighbors();
    for (Node node : grid.getNodes()) {
      root.getChildren().add(new Rectangle(node.getX()*10-5,node.getY()*10-5,10,10));
      System.out.print("\nNode: " + node + "Neighbors: ");
      for (Node neighbor : node.getNeighbors()) {
        root.getChildren().add(new Line(node.getX()*10,node.getY()*10,neighbor.getX()*10,neighbor.getY()*10));
        System.out.print(neighbor + " ");
      }
    }
    for (Barrier barrier : grid.getBarriers()) {
      Rectangle rect = new Rectangle(barrier.getX()*10-5,barrier.getY()*10-5,barrier.getW()*10+10,barrier.getH()*10+10);
      rect.setFill(Color.RED);
      root.getChildren().add(rect);
    }

    new AnimationTimer () {
      @Override
      public void handle(long now) {
        //animation stuff
      }
    }.start();
  }
  public static void main (String[] args) {
    launch(args);
  }
}
