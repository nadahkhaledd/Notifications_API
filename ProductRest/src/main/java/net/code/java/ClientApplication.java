package net.code.java;

import java.util.Scanner;

public class ClientApplication {
	public static void main(String[] args) {
		Log.logging();
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Do you want to dequeue from SMS or MAIL ?");
			String choice = input.nextLine();
			if(choice.equalsIgnoreCase("SMS")) {
				DequeueStrategy obj = new DequeueSMS();
				System.out.println(obj.dequeue());
				break;
			}
			else if(choice.equalsIgnoreCase("MAIL")) {
				DequeueStrategy obj = new DequeueMAIL();
				System.out.println(obj.dequeue());
				break;
			}
			else {
				System.out.println("Please enter a proper type of queue");
			}
		}
		input.close();		
	}
}
