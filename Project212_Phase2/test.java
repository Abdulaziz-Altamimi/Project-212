import java.util.Scanner;
import java.util.InputMismatchException;
public class test {

	public static void main(String[] args) {
		/*Contact c1 = new Contact("ahmad","Khalid ","123"," "," "," "," ");
		Contact c2 = new Contact("ahmad","Bdr ","23","23"," "," "," ");
		Contact c3 = new Contact("ahmad","Ali ","56","56"," "," "," ");
		Contact c4 = new Contact("ahmad","Z","78","78",""," "," ");
		Contact c5 = new Contact("ahmad","Y","78","78",""," "," ");
		
		BST<Contact> b1 = new BST<Contact>();
		b1.insert("ahmad Khalid", c1);
		b1.insert("ahmad Bdr", c2);
		b1.insert("ahmad Ali", c3);
		b1.insert("ahmad Z", c4);
		b1.insert("ahmad Y", c5);
		//System.out.println(b1.checkPhone("78"));
		//b1.print_fname("ahmad");
		b1.removeKey("ahmad Khalid");
		b1.print_fname("ahmad");
		//b1.p();
*/
		PhoneBook pb= new PhoneBook();
		System.out.println("Welcome to the BST Phonebook!");
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
			
			
			switch(choice){
			case 1:
				pb.add_contact();
				break;
			case 2:
				pb.search();
				break;
			case 3:
				pb.Delete_contact(); 
				break;
			case 4:
				pb.Schedule_event1();
				break;
			case 5:
				pb.print_event_details();
				break;
			case 6:
				pb.print_F();
				break;
			case 7:
				pb.Print_All_Events();
				break;
			case 8:
				break;
			default:
				System.out.println("wrong input Try again!\n");
				break;
			
			}
			}catch(InputMismatchException e) {
				System.out.println("\nWrong input!\n");
			}
			
		}while(choice!=8);
		System.out.println("\nGoodbye!");
		

	
	}

}
