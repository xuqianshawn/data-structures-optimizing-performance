package leetCode;

import java.util.*;


import org.reactfx.value.Var;

public class MergeArrayList {
	public static ArrayList mergeTwoArraylist(ArrayList l1, ArrayList l2) {
		int duplicateCount = 0;		
		if (l1.isEmpty()) {
			System.out.println(duplicateCount);
			return l2;
		}
		if (l2.isEmpty()) {
			System.out.println(duplicateCount);
			return l1;
		}
		for (Object e : l1) {
			if (l2.contains(e)) {
				duplicateCount++;
			} else {
				l2.add(e);
			}
		}
		System.out.println(duplicateCount);
		Collections.sort(l2, Collections.reverseOrder());
		return l2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(5);
		l2.add(3);
		l2.add(4);
		mergeTwoArraylist(l1,l2);
		System.out.println(l2);
	}

}
