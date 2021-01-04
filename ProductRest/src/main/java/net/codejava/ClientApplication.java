package net.codejava;

import java.util.Scanner;

public class ClientApplication {
	public static void main(String[] args) {
		Log.Logging();
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Do you want to dequeue from SMS or MAIL ?");
			String choice = input.nextLine();
			if(choice.equalsIgnoreCase("SMS")) {
				Client.dequeueSMS();
				break;
			}
			else if(choice.equalsIgnoreCase("MAIL")) {
				Client.dequeueMAIL();
				break;
			}
			else {
				System.out.println("Please enter a proper type of queue");
			}
		}
		input.close();		
	}
}
