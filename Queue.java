import java.util.ArrayList;
import java.util.Scanner;

public class Queue {
	
	//Function to add data to the queue
	static void Enqueue(ArrayList<Integer> a, int num) {
		a.add(num);
	}
	
	//Function to delete data from the queue
	static void Dequeue(ArrayList<Integer> a) {
		a.remove(a.get(0));
		PrintQueue(a);
	}
	
	//Function to print the queue
	static void PrintQueue(ArrayList<Integer> a) {
		for(int i = 0; i < a.size(); i++) {
			System.out.print(a.get(i) + "\t");
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		int option;
		boolean loop = true;
		while(loop) {
			System.out.println("Enter the option to do the following operation");
			System.out.println("1. Enqueue \n2. Dequeue \n3. Print \n4. End and Print");
			option = s.nextInt();
			switch(option) {
				case 1: System.out.print("Enter the number to Enqueue : ");
						int num = s.nextInt(); 
						Enqueue(a, num);
						System.out.print("\n");
					break;
				case 2: Dequeue(a);
					break;
				case 3: PrintQueue(a);
					break;
				case 4: PrintQueue(a);
						loop = false;
					break;
				default: System.out.println("Enter the correct option. Try Again");
			}
		}
		s.close();
	}
}
