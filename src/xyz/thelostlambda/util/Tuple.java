package xyz.thelostlambda.util;

public class Tuple {
//variables
  private double x;
  private double y;

//constructors
  public Tuple () {
    this.x = 0;
    this.y = 0;
  }
  public Tuple (double x, double y) {
    this.x = x;
    this.y = y;
  }
//getters
  public double getX () {
    return this.x;
  }
  public double getY () {
    return this.y;
  }

//setters
  public void setX (double x) {
    this.x = x;
  }
  public void setY (double y) {
    this.y = y;
  }

//methods
  @Override
  public String toString () {
    return ("["+x+", "+y+"]");
  }
  public boolean equals (Tuple t) {
    return (x == t.getX() && y == t.getY());
  }
}
