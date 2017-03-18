package xyz.thelostlambda.util;

import java.util.ArrayList;

public class Node extends Point {
//variables
  private Grid grid;
  private ArrayList<Node> neighbors = new ArrayList<Node>();

//constructors
  public Node (double x, double y) {
    super(x,y);
  }

//getters
  public Grid getGrid () {
    return this.grid;
  }
  public ArrayList<Node> getNeighbors () {
    return this.neighbors;
  }

//setters
  public void setGrid (Grid g) {
    grid = g;
  }

//methods
  public void findNeighbors () {
    neighbors.clear();
    boolean neighbor;
    for (Node node : this.getGrid().getNodes()) {
      neighbor = true;
      for (Barrier barrier : this.getGrid().getBarriers()) {
        if ((this.equals(node)) || (barrier.isBetween(this,node))) {
          neighbor = false;
        }
      }
      if (neighbor) {
        neighbors.add(node);
      }
    }
  }

}
