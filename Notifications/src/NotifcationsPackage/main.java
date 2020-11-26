package NotifcationsPackage;

import java.sql.SQLException;

/* Queries for database 
CREATE table signuptemplate(Name varchar(45),Email varchar(45),id varchar(20) UNIQUE,template varchar(100));
CREATE table bookingtemplate(name varchar(45),item varchar(45),id varchar(20) UNIQUE,template varchar(100));
CREATE table forgetpasstemplate(name varchar(45),resetpass varchar(45), id varchar(20) UNIQUE,template varchar(100));
*/
public class main {

	public static void main(String[] args) throws SQLException {
		NotificationTemplate t1 = new SignupTemplate();
		//t1.create("hello ${ahmed} your email is ${ahmedemail} with request No. ${1}");
		//t1.update("hello ${ahmed} your email is ${ahmedemail} with request No. ${1} , done");
		System.out.println(t1.read("signuptemplate ","1"));

		NotificationTemplate t2 = new ForgetPassTemplate();
		//t2.create("Dear ${Ali} your can reset your passworf from ${link} with request No. ${1}");
		//t2.update("Dear ${Ali} your can reset your passworf from ${link} with request No. ${1} ,thank u");
		System.out.println(t2.read("forgetpasstemplate ","1"));

		NotificationTemplate t3 = new BookingTemplate();
		//t3.create("Dear ${hassan} your booking of the item ${mobile charger} with request No. ${1} is confirmed");
		//t3.update("Dear ${hassan} your booking of the item ${mobile charger} with request No. ${1} is confirmed,thanks for using our store ");
		System.out.println(t3.read("bookingtemplate ","1"));

}
}