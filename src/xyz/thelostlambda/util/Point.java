package xyz.thelostlambda.util;

public class Point extends Tuple {
  public Point (double x, double y) {
    super(x,y);
  }
  public double distanceTo (Point p) {
    double xDiff = this.getX() - p.getX();
    double yDiff = this.getY() - p.getY();
    double dist = Math.sqrt( Math.pow(xDiff, 2) + Math.pow(yDiff, 2) );
    return dist;
  }
}
