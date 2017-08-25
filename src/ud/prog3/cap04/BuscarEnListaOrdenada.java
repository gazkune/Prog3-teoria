package ud.prog3.cap04;

//import java.io.*;

public class BuscarEnListaOrdenada {
	
	//Binary Search Method
	// This method accepts a pre-sorted array, the subscript of the starting element for the search,
	// the subscript of the ending element for the search,
	// and the key number for which we are searching.
	public static int binarySearch(int[] findIn, int target, int begin, int end)
		{
		// end is one past the last element, i.e. [begin, end) is a half-open interval.
		  if (begin < end)
		  {
		    int m = (begin+end)/2;
		    if (target==findIn[m])
		      return m;
		    else if (target<findIn[m])
		      return binarySearch(findIn, target, begin, m);
		    else
		      return binarySearch(findIn, target, m+1, end);
		  }
		  else // begin>=end, i.e. no valid array to search
		    return -1;
		}

	public static void main(String[] args)
    {
		// Poned aquí los valores que queráis para hacer vuestras pruebas
        int key = 77; 
        int[ ] num = {21, 27, 32, 40, 45, 51, 68, 77, 82, 100};

        //The binary search method   
        int index = binarySearch(num, key, 0, 9);
        System.out.println("Found in index: " + index);
    }	
}
