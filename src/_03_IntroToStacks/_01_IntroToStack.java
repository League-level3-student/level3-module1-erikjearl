package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;
import java.util.Stack;

public class _01_IntroToStack {
	static Random r = new Random();
			
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> stck = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		for(int i = 0; i < 100; i++) {
			stck.push(r.nextDouble()*100);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
			String str1 = JOptionPane.showInputDialog("enter a number between 0 and 100, inclusive");
			String str2 = JOptionPane.showInputDialog("enter a number between 0 and 100, inclusive");
			int smaller = Integer.parseInt(str1);
			int bigger = Integer.parseInt(str2);
			if(smaller > bigger) {
				 smaller = Integer.parseInt(str2);
				 bigger = Integer.parseInt(str1);
			}
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
			System.out.println("Popping elements off stack...");
			System.out.println(" Elements between " + smaller + " and " + bigger);
			while(stck.size() > 0) {
				double i = stck.pop();
				if(i > smaller && i < bigger) {
					System.out.println(i);
				}
			}
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
