package leetCode;
import java.util.*;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class test
{
    double getSquaredDistance(List<Integer> list)
    {
        double square=0;
        for(Integer i : list)
        {
            square=square+i*i;
        }
        return square;
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<List<Integer>> closestLocations(int totalCrates, 
                                         List<List<Integer>> allLocations, 
                                         int truckCapacity)
	{
        // WRITE YOUR CODE HERE
        allLocations.sort(new Comparator<List<Integer>>(){
		@Override
		public int compare(List<Integer> l1, List<Integer> l2) {
		     //TODO return 1 if l2 should be before l1 
		     //     return -1 if l1 should be before l2
		     //     return 0 otherwise
			 if(getSquaredDistance(l1)<getSquaredDistance(l2))
			 {
				 return -1;
			 }
			 else if(getSquaredDistance(l1)>getSquaredDistance(l2)){
				
					 return 1;
				 
			 }
			 else {
				return 0;
			}
		}
	 });
	 //System.out.println(allocations);
	 return allLocations;
    }
    // METHOD SIGNATURE ENDS
}