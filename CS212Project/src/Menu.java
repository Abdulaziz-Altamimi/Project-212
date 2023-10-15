import java.util.Scanner;
import java.util.InputMismatchException;
public class Menu {

	public static void main(String[] args) {

		Phonebook pb= new Phonebook();
		System.out.println("Welcome to the Linked Tree Phonebook!");
		int choice=0;
		do {
			try {
				Scanner kb = new Scanner(System.in);
			System.out.println("Please choose an option: ");
			System.out.println("1. Add a contact");
			System.out.println("2. Search for a contact");
			System.out.println("3. Delete a contact");
			System.out.println("4. Schedule an event");
			System.out.println("5. Print event details");
			System.out.println("6. Print contacts by first name");
			System.out.println("7. Print all events alphabetically");
			System.out.println("8. Exit");
			System.out.println();
			System.out.print("Enter your choice: ");
			choice=kb.nextInt();
			
			}catch(InputMismatchException e) {
				System.out.println("Wrong input!");
			}
			switch(choice){
			case 1:
				pb.insert_contact();
				break;
			case 2:
				pb.search_contact();
				break;
			case 3:

				break;
			case 4:
				pb.Schedule_event();
				break;
			case 5:
				pb.print_event_details();
				break;
			case 6:
				pb.print_by_Fname();
				break;
			case 7:
				pb.Print_All_Events();
				break;
			case 8:
				break;
			default:
				System.out.println("wrong input Try again!");
				break;
			
				
		
			}
		}while(choice!=8);
		System.out.println("Goodbye!");

	}

}
