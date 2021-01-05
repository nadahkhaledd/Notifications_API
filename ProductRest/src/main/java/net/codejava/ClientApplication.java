package net.codejava;

import java.util.Scanner;

public class ClientApplication {
	public static void main(String[] args) {
		Log.logging();
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Do you want to dequeue from SMS or MAIL ?");
			String choice = input.nextLine();
			if(choice.equalsIgnoreCase("SMS")) {
				System.out.println(Client.dequeueSMS());
				break;
			}
			else if(choice.equalsIgnoreCase("MAIL")) {
				System.out.println(Client.dequeueMAIL());
				break;
			}
			else {
				System.out.println("Please enter a proper type of queue");
			}
		}
		input.close();		
	}
}
