import java.util.*;

/*
  Plane Graph
	0 1 2 3 4 5 6 7
	1               
	2              
	3                 
	4              
	5                 
	6                 
	7                
*/

class NQueensProblem {
	int[] nqueens;
	
	NQueensProblem(int n) {
		nqueens = new int[n];
	}
	
	public boolean doesqueenfight(int rowmax, int column) {
		//Below print statements are for my understanding of how it works. Ignore.

		/*
		System.out.println("ROW:" + rowmax + " COLUMN" + column);
		
		for(int z = 0; z < rowmax; z++) {
			
			//System.out.println("QUEENARRAY");
			System.out.print("Array " + "Row:" + z + "Column:" + nqueens[z] + "\t");
		}
		
		System.out.print("\n");
		*/
		
		
		//Check columns and diagonals in all rows 
		//below rowmax as whether queen is present
				
		for (int i = 0; i < rowmax; i++) {
			//Column check
			if (nqueens[i] == column ) {
				return true;
			}
			//diagonal check - Check whether they're in the same diagonal
			else if (Math.abs(rowmax - i) == Math.abs(column - nqueens[i])) {
				return true;
			}
		}
		return false;
	}
	public void solveproblem(int row, int size) {
		//System.out.println("ROW:" + row);
		
		for(int i = 0; i < size; i++) {
			//We try to find the appropriate column for the queen to be placed
			//Iterate over column (i is column).
			if(!doesqueenfight(row, i)) {
				//place the queen in that cell
				nqueens[row] = i;
				
				//If the queen is placed in last row
				//Then print the solution
				if(row == size-1) {
					System.out.println("Solution for " + size + " Queens problem");
					for(int j = 0; j < size; j++) {
						System.out.print(j + "," + nqueens[j] + "\t");
					}
					System.out.print("\n");
					break;
				}
				
				//Recursively call solve problem function by moving to the next row
				solveproblem(row + 1, size);
			}
		}
	}
}


public class NQueens {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter N to find solution for N-Queens problem");
		int n = s.nextInt();
		if (n > 0) {
			NQueensProblem queen = new NQueensProblem(n);
			queen.solveproblem(0,n);
		}
		else {
			System.out.println("Enter a positive integer");
		}
		s.close();
	}
}
