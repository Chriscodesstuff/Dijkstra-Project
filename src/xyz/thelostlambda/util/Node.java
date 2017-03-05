package xyz.thelostlambda.util;

import java.util.ArrayList;

public class Node extends Point {
//variables
  protected Grid grid;
  protected ArrayList<Node> neighbors = new ArrayList<Node>();

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
    for (Node node : this.getGrid().getNodes()) {
      for (Barrier barrier : this.getGrid().getBarriers()) {
        if ((this!=node) && (!barrier.isBetween(this,node))) {
          neighbors.add(node);
        }
      }
    }
  }

}
