package NotifcationsPackage;
import java.util.Scanner;
/*
CREATE database templates;
use templates;
CREATE table templatetable(name varchar(45),var varchar(45),id varchar(20) UNIQUE,type varchar(20), template varchar(100));
*/
/*
signup ->       "Hello ${x}, your email is ${y} with request NO. ${z}"
				"${x}, your email is ${y} with request NO. ${z}"
booking ->      "Dear ${x}, your order for ${y} is successfully done with NO. ${z}"
				"${x}, your order for ${y} is successfully done with NO. ${z}"
forgetpass ->   "Hello ${x}, to reset your password click the following link ${y} . requested NO. ${z}"
				"${x}, to reset your password click the following link ${y} . requested NO. ${z}"
*/
public class main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		NotificationTemplate obj = new NotificationTemplate();
		obj.setBehaviour(new DatabaseOperations());
		System.out.println("Would u like to 1-create 2-update 3-read 4-delete");
		int choice = input.nextInt();
		switch(choice) {
		case 1:
			obj.Create("Dear ${john}, your order for ${laptop} is successfully done with NO. ${11}");
			break;
		case 2:
			obj.update("${john}, your order for ${laptop} is successfully done with NO. ${11}");
			break;
		case 3:
			obj.read();
			break;
		case 4:
			obj.delete();
			break;
		}
		input.close();
		
	}

}
