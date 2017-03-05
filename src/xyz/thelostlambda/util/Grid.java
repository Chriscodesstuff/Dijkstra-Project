package xyz.thelostlambda.util;

import java.util.ArrayList;

public class Grid {
//variables
  ArrayList<Node> nodes = new ArrayList<Node>();
  ArrayList<Barrier> barriers = new ArrayList<Barrier>();

//getters
  public ArrayList<Node> getNodes () {
    return nodes;
  }
  public ArrayList<Barrier> getBarriers () {
    return barriers;
  }

//methods
  public void findNodeNeighbors () {
    for (Node node : nodes) {
      node.findNeighbors();
    }
  }
  public void addNode (double x, double y) {
    nodes.add(new Node(x,y));
    nodes.get(nodes.size()-1).setGrid(this);
    findNodeNeighbors();
  }
  public void addBarrier (double x, double y, double w, double h) {
    barriers.add(new Barrier(x,y,w,h));
    addNode(x-1,y-1);
    addNode(x-1,y+h+1);
    addNode(x+w+1,y-1);
    addNode(x+w+1,y+h+1);
  }

  @Override
  public String toString () {
    String output = "Nodes:";
    for (Node node : nodes) {
      output += (" " + node);
    }
    output += "\nBarriers:";
    for (Barrier barrier : barriers) {
      output += (" " + barrier);
    }
    return output;
  }
}
