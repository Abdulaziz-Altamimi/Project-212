import java.util.Scanner;
public class PhoneBook {
	public BST<Contact>ContactBST;

	Scanner kb= new Scanner(System.in);

	public PhoneBook() {
		ContactBST=new BST<Contact>();
	}


	public void add_contact() {
		System.out.print("Enter the contact's name: ");
		String Fname=kb.next();
		String Lname=kb.next();
		System.out.print("Enter the contact's phone number: ");
		String num=kb.next();
		System.out.print("Enter the contact's email address: ");
		String EAddres=kb.next(); 
		System.out.print("Enter the contact's address: ");
		String Address=kb.nextLine(); 
		Address=kb.nextLine(); 
		System.out.print("Enter the contact's birthday: ");
		String BirthDay=kb.next();
		System.out.print("Enter any notes for the contact: "); 
		String notes=kb.nextLine();
		notes=kb.nextLine();
		Contact c = new Contact(Fname, Lname,num,EAddres,Address,BirthDay,notes);
		if(ContactBST.checkPhone(num)|| !ContactBST.insert(c.getContact_Name(), c))
			System.out.println("The contact already exists."); 

		else
			System.out.println("\nContact added successfully!\n");
	}


	public void print_F() {
		System.out.print("\nEnter the First name: ");
		String name=kb.nextLine();
		ContactBST.print_fname(name);
	}

	public void search(String info) {
		if(ContactBST.empty())
			System.out.println("\nThe BST is empty!\n");

		else {
			System.out.println("\nEnter search criteria: ");
			System.out.println("1. Name");
			System.out.println("2. Phone Number");
			System.out.println("3. Email Address");
			System.out.println("4. Address");
			System.out.println("5. Birthday");
			System.out.print("Enter your choice: ");
			int choice = kb.nextInt();
			String input="";
			switch(choice){
			case 1: 
				System.out.print("Enter the contact name: ");
				kb.nextLine();
				input =kb.nextLine();
				break;
			case 2:
				System.out.print("Enter the contact Phone number: ");
				input = kb.next();
				break;
			case 3:
				System.out.print("Enter the contact Email Address: ");
				input = kb.next();
				break;
			case 4:
				System.out.print("Enter the contact Address: ");
				kb.nextLine();
				input = kb.nextLine();
				break;
			case 5:
				System.out.print("Enter the contact Birthday: ");
				input = kb.next();
				break;

			}
			ContactBST.search(input);

		}
	}
}
