package xyz.thelostlambda.runners;

import xyz.thelostlambda.util.*;

public class Runner {
  public static void main (String[] args) {
    Grid grid = new Grid();
    grid.addBarrier(1,1,5,5);
    grid.findNodeNeighbors();
    System.out.println(grid);
    System.out.print("Node 0: " + grid.getNodes().get(0) + " + Neighbors: ");
    for (Node node : grid.getNodes().get(0).getNeighbors()) {
      System.out.print(node + " ");
    }
  }
}
