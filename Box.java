public class Box 
{
private double length;
  private double width;
  private double height;

  public Box(double l, double w, double h) 
  {
  length = l;
    width = w;
    height = h;
  }

  public double volume( ) 
  {
    return  length * width * height;
  }
}//end class Box