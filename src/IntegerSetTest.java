
/* Introduction to Software Design Fall 2014
 * Author: Andrew Goettler
 * Problem: 8.13 Set of Integers (pg 356)
 * Problem description: Create an IntegerSet class. Each IntegerSet object holds integers
 * 		in the range 0-100, represented as booleans. A[i] is true if integer i is in the set,
 * 		A[j] is false if integer j is not in the set.
 */

public class IntegerSetTest 
{
	public static void main(String[] args) 
	{
		// create several instances of  IntegerSet objects
		IntegerSet emptySet = new IntegerSet(); // set with no elements
		IntegerSet oddSet = new IntegerSet(); // set with only odd integers
		IntegerSet evenSet = new IntegerSet(); // set with only even integers
		IntegerSet fullSet = new IntegerSet(); // set with all elements
		
		// oddSet will contain all of the odd integers from 0 - 100
		for ( int counter = 0; counter <= oddSet.SET_SIZE; counter++)
		{
			if ((counter % 2) != 0)
			{
				oddSet.insertElement(counter);
			}
		}
		
		// evenSet will contain all of the even integers from 0 - 100
		for (int counter = 0; counter <= evenSet.SET_SIZE; counter++)
		{
			if((counter % 2) == 0)
			{
				evenSet.insertElement(counter);
			}
		}
		
		for (int counter = 0; counter <= fullSet.SET_SIZE; counter++)
		{
			fullSet.insertElement(counter);
		}
				
		System.out.println("empty set: " + emptySet.toString());
		System.out.println("odd set: " + oddSet.toString());
		System.out.println("even set: " + evenSet.toString());
		System.out.println("full set: " + fullSet.toString());
		
		//odd set and even set should not be equivalent:
		System.out.println("odd equal even: " + oddSet.isEqualTo(evenSet));
		System.out.println("even equal odd: " + evenSet.isEqualTo(oddSet));
		
		// the union of the odd and even set should be a full set
		IntegerSet oddEvenUnion = IntegerSet.union(oddSet, evenSet);
		System.out.println("union of odd and even sets: " + oddEvenUnion.toString());
		System.out.println("union of odd and even equal to full set: " 
				+ oddEvenUnion.isEqualTo(fullSet));
		
		// the intersection of the odd and even sets should be an empty set
		IntegerSet oddEvenIntersect = IntegerSet.intersection(oddSet, evenSet);
		System.out.println("intersection of odd and even sets: " + oddEvenIntersect.toString());
		System.out.println("intersection of odd and even equal to empty set: " +
				oddEvenIntersect.isEqualTo(emptySet));
		
		// the complement of the odd set should be an even set
		IntegerSet oddComplement = IntegerSet.complement(oddSet);
		System.out.println("complement of odd set: " + oddComplement.toString());
		System.out.println("complement of odd set equal to even set: " + oddComplement.isEqualTo(evenSet));
		
		// test deleting elements and getting elements
		System.out.println("is 50 in the full set: " + fullSet.getElement(50));
		fullSet.deleteElement(50);
		System.out.println("after deletion, is 50 in the full set: " + fullSet.getElement(50));
	}
}
