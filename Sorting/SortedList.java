/**
   A class that implements the ADT sorted list by using an instance of LList.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 4.0
*/


public class SortedList<T extends Comparable<? super T>> implements SortedListInterface<T>{

   private ListInterface<T> list;

   public SortedList()
   {
      list = new LList<T>();
   } // end default constructor

   // 16.21
   public void add(T newEntry)
   {
      int newPosition = Math.abs(getPosition(newEntry));
      list.add(newPosition, newEntry);
   } // end add
   
   // 16.22
   public boolean remove(T anEntry)
   {
      boolean result = false;
      int position = getPosition(anEntry);
      
      if (position > 0)
      {
         list.remove(position);
         result = true;
      } // end if
      
      return result;
   } // end remove
   
   // 16.24
   public int getPosition(T anEntry)
   {
      int position = 1;
      int length = list.getLength();
      
      // Find position of anEntry
      while ( (position <= length) &&
              (anEntry.compareTo(list.getEntry(position)) > 0) )
      {
         position++;
      } // end while
      
      // See whether anEntry is in list
      if ( (position > length) ||
           (anEntry.compareTo(list.getEntry(position)) != 0) )
      {
         position = -position; // anEntry is not in list
      } // end if
      
      return position;
   } // end getPosition
   
   // 16.25
   public T getEntry(int givenPosition)
   {
      return list.getEntry(givenPosition);
   } // end getEntry

@Override
public boolean contains(T anEntry) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public T remove(int givenPosition) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	
}

@Override
public int getLength() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public T[] toArray() {
	// TODO Auto-generated method stub
	return null;
}
   
// . . .

} // end SortedList
