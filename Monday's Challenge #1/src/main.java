import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name, userReddit;
		int age;
		
		System.out.print("What is your name?: ");
		name = in.nextLine();
		System.out.print("what is your age?: ");
		age = in.nextInt();
		in.nextLine();
		System.out.print("What is your Reddit Username?: ");
		userReddit = in.nextLine();
		
		System.out.println("Your name is " + name + ", you are " + age + " years old, and your username is " + userReddit + ".");
		
		redditFileWriter(name, userReddit, age);
		
		in.close();		
	}
	
	public static void redditFileWriter(String name, String user, int age){
		PrintWriter outFile = null;
		try {
			outFile = new PrintWriter(new FileWriter("redditUser.txt",true));
			outFile.println(name + "," + age + "," + user);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			outFile.close();
		}
	}
}
