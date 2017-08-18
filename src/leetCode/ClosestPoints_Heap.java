package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import javax.xml.ws.AsyncHandler;

import org.w3c.dom.css.ElementCSSInlineStyle;

class Point {
	private int _x;
	private int _y;

	Point(int x, int y) {
		_x = x;
		_y = y;
	}

	double getDistance() {
		return _x * _x + _y * _y;
	}
}

public class ClosestPoints_Heap {
	static class MyComparator implements Comparator<Point>
	{
		@Override
	    public int compare( Point x, Point y )
	    {
	    	if(y.getDistance()>x.getDistance())
	    	{
	        return -1;
	    	}
	    	else if(y.getDistance()<x.getDistance())
	    	{
	    	return 1;	
	    	}
	    	else {
	    	return 0;
			}
	    }
	}
    public static Point[] getKclosestPoints(Point[] points, int k){
    	PriorityQueue<Point> Heap=new PriorityQueue<Point>(k, new MyComparator());
    	ArrayList<Point> arrayList=new ArrayList<Point>();
		for(Point p:points)
		{
			Heap.offer(p);
		}
		System.out.println("heap size "+Heap.size());
//    	Iterator<Point> iter = Heap.iterator();
//        while(iter.hasNext()){
//        	arrayList.add(iter.next());
//        }
		while(!Heap.isEmpty() && k>0) {
			arrayList.add(Heap.poll());
			k--;
			}
    	return arrayList.toArray(new Point[arrayList.size()]);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 ArrayList<Point> arrPoints=new ArrayList<Point>();
	 arrPoints.add(new Point(10, 1));
	 arrPoints.add(new Point(1, 8));
	 arrPoints.add(new Point(9, 1));
	 arrPoints.add(new Point(5, 5));
	 arrPoints.add(new Point(3, 8));
	 arrPoints.add(new Point(1, 1));
	 arrPoints.add(new Point(5, 2));
	 arrPoints.add(new Point(2, 7));
	 arrPoints.add(new Point(7, 8));
     Point[] points= arrPoints.toArray(new Point[arrPoints.size()]);
     Point[] outputs=getKclosestPoints(points,3);
     for(Point p:outputs)
     {
    	 System.out.println(p.getDistance());
     }
	}

}
