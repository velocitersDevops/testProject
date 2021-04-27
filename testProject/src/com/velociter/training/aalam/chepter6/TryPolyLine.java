package com.velociter.training.aalam.chepter6;


public class TryPolyLine 
{
   public static void main(String[] args) 
   {
      // Create an array of coordinate pairs:
      double[][] coords = { {1., 1.}, {1., 2.}, { 2., 3.},
                            {-3., 5.}, {-5., 1.}, {0., 0.} };

      // Create a polyline from the coordinates and display it:
      PPolyLine polygon = new PPolyLine(coords);
      polygon.show();

      // Add a point and display the polyline again:
      polygon.addPoint(10., 10.);
      polygon.show();

      // Create Point objects from the coordinate array:
      Point[] points = new Point[coords.length];
      for(int i = 0; i < points.length; i++)
         points[i] = new Point(coords[i][0],coords[i][1]);

      // Use the points to create a new polyline and display it:
      PolyLine newPoly = new PolyLine(points);
      newPoly.show();
   }
}

