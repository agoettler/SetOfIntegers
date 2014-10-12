
/* Introduction to Software Design Fall 2014
 * Author: Andrew Goettler
 * Problem: 8.13 Set of Integers (pg 356)
 * Problem description: Create an IntegerSet class. Each IntegerSet object holds integers
 * 		in the range 0-100, represented as booleans. A[i] is true if integer i is in the set,
 * 		A[j] is false if integer j is not in the set.
 */

import java.util.Arrays;

/** 
 * This class represents a set of integers using an array of booleans.
 * Element i is true if integer i is in the set, false if it is not.
 * 
 * @author Andrew Goettler
 *
 */
public class IntegerSet 
{
	final int SET_SIZE = 100; // constant for the number of elements IntegerSet can hold
	private boolean[] elementArray; // array for storing set elements
	
	/** 
	 * This method initializes the element array to an "empty set" of 100 elements
	 * set to false.
	 * 
	 */
	/* 
	 * default no-argument constructor
	 * 
	 * using SET_SIZE for the array size will give an array that is one element
	 * too small, so the array size must be SET_SIZE + 1
	 */
	public IntegerSet()
	{
		elementArray = new boolean[SET_SIZE + 1];
		Arrays.fill(elementArray, false);
	}
	
	/** 
	 * This method generates the set-theoretic union of the specified pair of sets.
	 * An element is in the returned set if it was in either or both of 
	 * the specified sets.
	 * 
	 * @param setA
	 * @param setB
	 * @return the union of setA and setB
	 */
	/*
	 *  public class method for generating the union of two sets
	 *  
	 */
	public static IntegerSet union( IntegerSet setA, IntegerSet setB )
	{
		IntegerSet resultSet = new IntegerSet();
		
		for (int counter = 0; counter <= resultSet.SET_SIZE; counter++ )
		{
			resultSet.modifyElement(counter, (setA.getElement(counter) || setB.getElement(counter))) ;
		}
		
		return resultSet;
	}
	
	/** 
	 * This method generates the set-theoretic intersection of the specified pair of sets.
	 * An element is in the returned set only if it was in both of the specified sets.
	 * 
	 * @param setA
	 * @param setB
	 * @return the intersection of setA and setB
	 */
	// public class method for generating the intersection of two sets
	public static IntegerSet intersection( IntegerSet setA, IntegerSet setB )
	{
		IntegerSet resultSet = new IntegerSet();
		
		for (int counter = 0; counter <= resultSet.SET_SIZE; counter++ )
		{
			resultSet.modifyElement(counter, (setA.getElement(counter) && setB.getElement(counter))) ;
		}
		
		return resultSet;
	}
	
	/**
	 * This method generates the set-theoretic complement of the specified set.
	 * The complement of a set contains all of the elements not in the set.
	 * 
	 * @param originalSet 
	 * @return the complement of originalSet
	 */
	// public class method for generating the complement of a set, a useful operation
	public static IntegerSet complement(IntegerSet originalSet)
	{
		IntegerSet resultSet = new IntegerSet();
		
		for (int counter = 0; counter <= resultSet.SET_SIZE; counter++)
		{
			resultSet.modifyElement(counter, !(originalSet.getElement(counter)));
		}
		
		return resultSet;	
	}
	
	
	/**
	 * This method indicates if a particular element is in the set.
	 * 
	 * @param element 
	 * @return true if the element is in the set, otherwise returns false
	 */
	// public object method to determine if a particular element is in the set
	public boolean getElement( int element )
	{
		if ((element >= 0) && (element <= SET_SIZE))
		{
			return elementArray[element];
		}
		
		else
		{
			/*TODO while this is set-theoretically correct response for 
			 * an out-of-bounds element, it may not be ideal from an
			 * error handling perspective
			 * 
			 */
			return false;
		}
	}
	
	/**
	 * This method sets the specified element in the set to the specified value.
	 * It is a private method since all public insertions and removals to the 
	 * set should be handled by the inserteElement and deleteElement methods,
	 * respectively.
	 * 
	 * @param element
	 * @param value
	 */
	private void modifyElement( int element, boolean value)
	{
		if ((element >= 0) && (element <= SET_SIZE))
		{
			elementArray[element] = value;
		}
		
		// TODO find a better way of handling out-of-bounds elements than simply ignoring them
	}
	
	/** 
	 * Adds an integer to the set by setting the specified element to true.
	 * 
	 * @param element integer to be inserted into the set
	 */
	// public object method for inserting an element into the set
	public void insertElement( int element )
	{
		this.modifyElement(element,  true);
	}
	
	/** 
	 * Removes an integer from the set by setting the specified element to false.
	 * 
	 * @param element integer to be removed from the set
	 */
	// public object method for removing an element from the set
	public void deleteElement( int element )
	{
		this.modifyElement(element, false);
	}
	
	/** 
	 * Compares the calling set to the specified set to determine if they
	 * are equivalent.
	 * 
	 * @param otherSet the set to be compared
	 * @return true if sets are equivalent, otherwise returns false
	 */
	/*
	 * Iterates through all elements in both sets. If a particular element has different
	 * values in each set, the method returns false and the loop terminates early.
	 * If the end of the loop is reached without encountering a difference, then the
	 * two sets are equivalent, and the method returns true.
	 */
	public boolean isEqualTo( IntegerSet otherSet )
	{
		for ( int counter = 0; counter <= this.SET_SIZE; counter++)
		{
			if ( this.getElement(counter) != otherSet.getElement(counter) )
			{
				return false;
			}
		}
		
		return true;
	}
	
	/** 
	 * Returns a string representation of the set as a list of numbers
	 * separated by spaces. Only the integers present in the set are included;
	 * the empty set is represent as {---}.
	 * 
	 */
	// public toString method
	public String toString()
	{
		String setString = "{";
		int cardinality = 0;
		
		for ( int counter = 0 ; counter <= SET_SIZE; counter++ )
		{
			if( this.getElement(counter) )
			{
				setString = setString + " " +  counter;
				cardinality++;
			}
		}
		
		setString = setString + " }";
		
		if ( cardinality != 0 )
		{
			return setString;
		}
		
		else
		{
			return "{---}";
		}
		
	}
}
